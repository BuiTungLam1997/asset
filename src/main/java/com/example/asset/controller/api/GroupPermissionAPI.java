package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.GroupPermissionDTO;
import com.example.asset.service.IGroupPermissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/groupPermission")
@AllArgsConstructor
public class GroupPermissionAPI {

    IGroupPermissionService groupPermissionService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<GroupPermissionDTO>>> list() {
        try {
            List<GroupPermissionDTO> list = groupPermissionService.findAll();
            return new ResponseEntity<>(new ResponseService<>(list, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseService<GroupPermissionDTO>> getGroupPermission(@PathVariable Long id) {
        try {
            Optional<GroupPermissionDTO> groupPermissionDTO = groupPermissionService.findById(id);
            return groupPermissionDTO
                    .map(groupPermissionDTO1 -> new ResponseEntity<>(new ResponseService<>(groupPermissionDTO1, "Success", "200"), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(new ResponseService<>("Error! ID not found :" + id, "400"), HttpStatus.OK));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-groupPermission")
    public ResponseEntity<ResponseService<GroupPermissionDTO>> createGroupPermission(@RequestBody GroupPermissionDTO groupPermissionDTO) {
        try {
            GroupPermissionDTO groupPermissionDTO1 = groupPermissionService.insert(groupPermissionDTO);
            return new ResponseEntity<>(new ResponseService<>(groupPermissionDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-groupPermission")
    public ResponseEntity<ResponseService<GroupPermissionDTO>> updateGroupPermission(@RequestBody GroupPermissionDTO groupPermissionDTO) {
        try {
            GroupPermissionDTO groupPermissionDTO1 = groupPermissionService.insert(groupPermissionDTO);
            return new ResponseEntity<>(new ResponseService<>(groupPermissionDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-groupPermission")
    public ResponseEntity<ResponseService<List<GroupPermissionDTO>>> deleteGroupPermission(@RequestParam List<Long> ids) {
        try {
            groupPermissionService.delete(ids);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }
}
