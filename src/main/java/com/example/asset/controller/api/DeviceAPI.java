package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.DeviceDTO;
import com.example.asset.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/device")
public class DeviceAPI {

    @Autowired
    IDeviceService deviceService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<DeviceDTO>>> listDevice() {
        try {
            List<DeviceDTO> list = deviceService.findAll();
            return new ResponseEntity<>(new ResponseService<>(list, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseService<DeviceDTO>> getDevice(@PathVariable Long id) {
        try {
            Optional<DeviceDTO> deviceDTO = deviceService.findById(id);
            return deviceDTO.map(deviceDTO1 -> new ResponseEntity<>(new ResponseService<>(deviceDTO1, "Success", "200"), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(new ResponseService<>("Error! Không tồn tại thiết bị có id :" + id, "400"), HttpStatus.OK));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-device")
    public ResponseEntity<ResponseService<DeviceDTO>> insertDevice(@RequestBody DeviceDTO deviceDTO) {
        try {
            DeviceDTO device = deviceService.insert(deviceDTO);
            return new ResponseEntity<>(new ResponseService<>(device, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-device")
    public ResponseEntity<ResponseService<DeviceDTO>> updateDevice(@RequestBody DeviceDTO deviceDTO) {
        try {
            DeviceDTO device = deviceService.insert(deviceDTO);
            return new ResponseEntity<>(new ResponseService<>(device, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-device")
    public ResponseEntity<ResponseService<DeviceDTO>> deleteDevice(@RequestParam List<Long> ids) {
        try {
            deviceService.delete(ids);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }
}
