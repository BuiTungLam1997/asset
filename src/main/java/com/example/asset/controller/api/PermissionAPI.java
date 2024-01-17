package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.PermissionDTO;
import com.example.asset.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api.v1/permission")
public class PermissionAPI {

    @Autowired
    IPermissionService permissionService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<PermissionDTO>>> list() {
        try {
            List<PermissionDTO> list = permissionService.findAll();
            return new ResponseEntity<>(new ResponseService<>(list, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseService<PermissionDTO>> getPermission(@PathVariable Long id) {
        try {
            Optional<PermissionDTO> permissionDTO = permissionService.findById(id);
            return permissionDTO.map(permissionDTO1 -> new ResponseEntity<>(new ResponseService<>(permissionDTO1, "Success", "200"), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(new ResponseService<>("Error! ID not found :" + id, "500"), HttpStatus.OK));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-permission")
    public ResponseEntity<ResponseService<PermissionDTO>> createPermission(@RequestBody PermissionDTO permissionDTO) {
        try {
            PermissionDTO permissionDTO1 = permissionService.insert(permissionDTO);
            return new ResponseEntity<>(new ResponseService<>(permissionDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-permission")
    public ResponseEntity<ResponseService<PermissionDTO>> updatePermission(@RequestBody PermissionDTO permissionDTO) {
        try {
            PermissionDTO permissionDTO1 = permissionService.insert(permissionDTO);
            return new ResponseEntity<>(new ResponseService<>(permissionDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-permission")
    public ResponseEntity<ResponseService<PermissionDTO>> deletePermission(@RequestParam List<Long> ids) {
        try {
            permissionService.delete(ids);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

}
