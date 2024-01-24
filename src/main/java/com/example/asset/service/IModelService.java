package com.example.asset.service;

import com.example.asset.dto.ModelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IModelService {
    ModelDTO insert(ModelDTO modelDTO);

    ModelDTO update(ModelDTO modelDTO);

    void delete(List<Long> ids);

    ModelDTO findById(Long id);

    List<ModelDTO> findAll();

    Page<ModelDTO> page(Pageable pageable);
}
