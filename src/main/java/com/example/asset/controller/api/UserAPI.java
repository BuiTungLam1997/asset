package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.UserDTO;
import com.example.asset.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.asset.dto.constant.Pageable.defaultLimit;
import static com.example.asset.dto.constant.Pageable.defaultPage;

@RestController
@RequestMapping(value = "/api/v1/user")
@AllArgsConstructor
public class UserAPI {

    IUserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<UserDTO>>> list(
            @RequestParam(required = false, defaultValue = "" + defaultPage + "") Integer page,
            @RequestParam(required = false, defaultValue = "" + defaultLimit + "") Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        try {
            Page<UserDTO> data = userService.findAll(pageable);
            return new ResponseEntity<>(new ResponseService<>(data.getContent(), "Success", "200", data.getTotalPages(), page, limit), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping(value = "/get/{id}")
    ResponseEntity<ResponseService<UserDTO>> selectUser(@PathVariable Long id) {
        try {
            Optional<UserDTO> user = userService.findById(id);
            return user.map(userDTO -> new ResponseEntity<>(new ResponseService<>(userDTO, "Success", "200"), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(new ResponseService<>("Error!", "500"), HttpStatus.OK));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/search/{search}")
    public ResponseEntity<ResponseService<List<UserDTO>>> search(
            @RequestParam(required = false, defaultValue = "" + defaultPage + "") Integer page,
            @RequestParam(required = false, defaultValue = "" + defaultLimit + "") Integer limit,
            @PathVariable String search) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        try {
            Page<UserDTO> data = userService.search(pageable, search);
            return new ResponseEntity<>(new ResponseService<>(data.getContent(), "Success", "200", data.getTotalPages(), page, limit), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PutMapping(value = "/update-user")
    ResponseEntity<ResponseService<List<UserDTO>>> updateUser(@RequestBody UserDTO userDTO) {
        try {
            userService.update(userDTO);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-user")
    ResponseEntity<ResponseService<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
        try {
            userService.insert(userDTO);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }
}
