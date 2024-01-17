package com.example.asset.service.impl;

import com.example.asset.dto.GroupPermissionDTO;
import com.example.asset.mapper.GroupPermissionMapper;
import com.example.asset.repository.GroupPermissionRepository;
import com.example.asset.service.IGroupPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupPermissionService implements IGroupPermissionService {

    @Autowired
    GroupPermissionRepository groupPermissionRepository;
    @Autowired
    GroupPermissionMapper groupPermissionMapper;

    @Override
    public GroupPermissionDTO insert(GroupPermissionDTO groupPermissionDTO) {
        return groupPermissionMapper.toDTO(groupPermissionRepository.save(groupPermissionMapper.toEntity(groupPermissionDTO)));
    }

    @Override
    public GroupPermissionDTO update(GroupPermissionDTO groupPermissionDTO) {
        return groupPermissionMapper.toDTO(groupPermissionRepository.save(groupPermissionMapper.toEntity(groupPermissionDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        groupPermissionRepository.deleteAllById(ids);
    }

    @Override
    public Optional<GroupPermissionDTO> findById(Long id) {
        return Optional.ofNullable(groupPermissionMapper.opToDTO(groupPermissionRepository.findById(id)));
    }

    @Override
    public List<GroupPermissionDTO> findAll() {
        return groupPermissionRepository.findAll().stream().map(groupPermissionMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<GroupPermissionDTO> page(Pageable pageable) {
        return groupPermissionRepository.findAll(pageable).map(groupPermissionMapper::toDTO);
    }
}
