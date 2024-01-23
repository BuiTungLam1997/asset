package com.example.asset.controller.api;

import com.example.asset.controller.output.ResponseService;
import com.example.asset.dto.ModelDTO;
import com.example.asset.service.IModelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/model")
@AllArgsConstructor
public class ModelAPI {

    IModelService modelService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseService<List<ModelDTO>>> list() {
        try {
            List<ModelDTO> list = modelService.findAll();
            return new ResponseEntity<>(new ResponseService<>(list, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseService<ModelDTO>> getModel(@PathVariable Long id) {
        try {
            Optional<ModelDTO> modelDTO = modelService.findById(id);
            return modelDTO.map(modelDTO1 -> new ResponseEntity<>(new ResponseService<>(modelDTO1, "Success", "200"), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(new ResponseService<>("Error! ID not found :" + id, "500"), HttpStatus.OK));

        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-model")
    public ResponseEntity<ResponseService<ModelDTO>> createModel(@RequestBody ModelDTO modelDTO) {
        try {
            ModelDTO modelDTO1 = modelService.insert(modelDTO);
            return new ResponseEntity<>(new ResponseService<>(modelDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-model")
    public ResponseEntity<ResponseService<ModelDTO>> updateModel(@RequestBody ModelDTO modelDTO) {
        try {
            ModelDTO modelDTO1 = modelService.update(modelDTO);
            return new ResponseEntity<>(new ResponseService<>(modelDTO1, "Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-model")
    public ResponseEntity<ResponseService<ModelDTO>> deleteModel(@RequestParam List<Long> ids) {
        try {
            modelService.delete(ids);
            return new ResponseEntity<>(new ResponseService<>("Success", "200"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ResponseService<>(exception.getMessage(), "500"), HttpStatus.BAD_REQUEST);
        }
    }
}
