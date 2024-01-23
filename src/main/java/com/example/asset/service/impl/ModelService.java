package com.example.asset.service.impl;

import com.example.asset.dto.ModelDTO;
import com.example.asset.mapper.ModelMapper;
import com.example.asset.repository.ModelRepository;
import com.example.asset.service.IModelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelService implements IModelService {


    ModelRepository modelRepository;

    ModelMapper modelMapper;

    @Override
    public ModelDTO insert(ModelDTO modelDTO) {
        return modelMapper.toDTO(modelRepository.save(modelMapper.toEntity(modelDTO)));
    }

    @Override
    public ModelDTO update(ModelDTO modelDTO) {
        return modelMapper.toDTO(modelRepository.save(modelMapper.toEntity(modelDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        modelRepository.deleteAllById(ids);
    }

    @Override
    public Optional<ModelDTO> findById(Long id) {
        return Optional.ofNullable(modelMapper.opToDTO(modelRepository.findById(id)));
    }

    @Override
    public List<ModelDTO> findAll() {
        return modelRepository.findAll().stream().map(modelMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<ModelDTO> page(Pageable pageable) {
        return modelRepository.findAll(pageable).map(modelMapper::toDTO);
    }
}
