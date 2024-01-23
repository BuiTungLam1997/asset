package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.GroupUserDTO;
import com.example.asset.service.IGroupUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/groupUser")
@AllArgsConstructor
public class GroupUserAPI {

    IGroupUserService groupUserService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<GroupUserDTO>>> list() {
        try {
            List<GroupUserDTO> list = groupUserService.findAll();
            return new ResponseEntity<>(new ResponseService<>(list, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseService<GroupUserDTO>> getGroupUser(@PathVariable Long id) {
        try {
            Optional<GroupUserDTO> groupUserDTO = groupUserService.findById(id);
            return groupUserDTO.map(groupUserDTO1 -> new ResponseEntity<>(new ResponseService<>(groupUserDTO1, "Success", "200"), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(new ResponseService<>("Error! ID not found :" + id, "500"), HttpStatus.OK));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-groupUser")
    public ResponseEntity<ResponseService<GroupUserDTO>> createGroupUser(@RequestBody GroupUserDTO groupUserDTO) {
        try {
            GroupUserDTO groupUserDTO1 = groupUserService.insert(groupUserDTO);
            return new ResponseEntity<>(new ResponseService<>(groupUserDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-groupUser")
    public ResponseEntity<ResponseService<GroupUserDTO>> updateGroupUser(@RequestBody GroupUserDTO groupUserDTO) {
        try {
            GroupUserDTO groupUserDTO1 = groupUserService.update(groupUserDTO);
            return new ResponseEntity<>(new ResponseService<>(groupUserDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-groupUser")
    public ResponseEntity<ResponseService<GroupUserDTO>> deleteGroupUser(@RequestParam List<Long> ids) {
        try {
            groupUserService.delete(ids);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }
}
