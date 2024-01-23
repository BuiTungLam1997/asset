package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.AssetDTO;
import com.example.asset.service.IAssetService;
import lombok.AllArgsConstructor;
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
@RequestMapping(value = "/api/v1/asset")
@AllArgsConstructor
public class AssetAPI {

    IAssetService deviceService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<AssetDTO>>> listDevice(@RequestParam(required = false, defaultValue = "" + defaultPage + "") Integer page,
                                                                      @RequestParam(required = false, defaultValue = "" + defaultLimit + "") Integer limit) {
        try {
            Pageable pageable = PageRequest.of(page - 1, limit);
            Page<AssetDTO> list = deviceService.findAll(pageable);
            return new ResponseEntity<>(new ResponseService<>(list.getContent(), "Success", "200", list.getTotalPages(), page, limit), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseService<AssetDTO>> getDevice(@PathVariable Long id) {
        try {
            AssetDTO asset = deviceService.findById(id);
            return new ResponseEntity<>(new ResponseService<>(asset, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/search/{search}")
    public ResponseEntity<ResponseService<List<AssetDTO>>> getDevice(@PathVariable String search,
                                                                     @RequestParam(required = false, defaultValue = "" + defaultPage + "") Integer page,
                                                                     @RequestParam(required = false, defaultValue = "" + defaultLimit + "") Integer limit) {
        try {
            Pageable pageable = PageRequest.of(page - 1, limit);
            Page<AssetDTO> list = deviceService.search(pageable, search);
            return new ResponseEntity<>(new ResponseService<>(list.getContent(), "Success", "200", list.getTotalPages(), page, limit), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-asset")
    public ResponseEntity<ResponseService<AssetDTO>> insertDevice(@RequestBody AssetDTO assetDTO) {
        try {
            AssetDTO device = deviceService.insert(assetDTO);
            return new ResponseEntity<>(new ResponseService<>(device, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-asset")
    public ResponseEntity<ResponseService<AssetDTO>> updateDevice(@RequestBody AssetDTO assetDTO) {
        try {
            AssetDTO device = deviceService.insert(assetDTO);
            return new ResponseEntity<>(new ResponseService<>(device, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-asset")
    public ResponseEntity<ResponseService<AssetDTO>> deleteDevice(@RequestBody AssetDTO assetDTO) {
        try {
            deviceService.delete(assetDTO.getIds());
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }
}
