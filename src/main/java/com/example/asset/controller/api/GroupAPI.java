package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.GroupDTO;
import com.example.asset.service.IGroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/group")
@AllArgsConstructor
public class GroupAPI {

    IGroupService groupService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<GroupDTO>>> listGroup() {
        try {
            List<GroupDTO> list = groupService.findAll();
            return new ResponseEntity<>(new ResponseService<>(list, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseService<GroupDTO>> getGroup(@PathVariable Long id) {
        try {
            GroupDTO groupDTO = groupService.findById(id);
            return new ResponseEntity<>(new ResponseService<>(groupDTO, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-group")
    public ResponseEntity<ResponseService<List<GroupDTO>>> createGroup(@RequestBody GroupDTO groupDTO) {
        try {
            groupService.insert(groupDTO);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-group")
    public ResponseEntity<ResponseService<List<GroupDTO>>> updateGroup(@RequestBody GroupDTO groupDTO) {
        try {
            groupService.update(groupDTO);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-group")
    public ResponseEntity<ResponseService<List<GroupDTO>>> list(@RequestParam List<Long> ids) {
        try {
            groupService.delete(ids);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }
}
