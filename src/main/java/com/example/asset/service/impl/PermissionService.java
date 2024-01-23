package com.example.asset.service.impl;

import com.example.asset.dto.PermissionDTO;
import com.example.asset.mapper.PermissionMapper;
import com.example.asset.repository.PermissionRepository;
import com.example.asset.service.IPermissionService;
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
public class PermissionService implements IPermissionService {


    PermissionRepository permissionRepository;

    PermissionMapper permissionMapper;

    @Override
    public PermissionDTO insert(PermissionDTO permissionDTO) {
        return permissionMapper.toDTO(permissionRepository.save(permissionMapper.toEntity(permissionDTO)));
    }

    @Override
    public PermissionDTO update(PermissionDTO permissionDTO) {
        return permissionMapper.toDTO(permissionRepository.save(permissionMapper.toEntity(permissionDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        permissionRepository.deleteAllById(ids);
    }

    @Override
    public Optional<PermissionDTO> findById(Long id) {
        return Optional.ofNullable(permissionMapper.opToDTO(permissionRepository.findById(id)));
    }

    @Override
    public List<PermissionDTO> findAll() {
        return permissionRepository.findAll().stream().map(permissionMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<PermissionDTO> page(Pageable pageable) {
        return permissionRepository.findAll(pageable).map(permissionMapper::toDTO);
    }
}
