package com.example.asset.service.impl;

import com.example.asset.dto.GroupPermissionDTO;
import com.example.asset.dto.GroupUserDTO;
import com.example.asset.mapper.GroupUserMapper;
import com.example.asset.repository.GroupUserRepository;
import com.example.asset.service.IGroupPermissionService;
import com.example.asset.service.IGroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupUserService implements IGroupUserService {

    @Autowired
    GroupUserRepository groupUserRepository;
    @Autowired
    GroupUserMapper groupUserMapper;


    @Override
    public GroupUserDTO insert(GroupUserDTO groupUserDTO) {
        return groupUserMapper.toDTO(groupUserRepository.save(groupUserMapper.toEntity(groupUserDTO)));
    }

    @Override
    public GroupUserDTO update(GroupUserDTO groupUserDTO) {
        return groupUserMapper.toDTO(groupUserRepository.save(groupUserMapper.toEntity(groupUserDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        groupUserRepository.deleteAllById(ids);
    }

    @Override
    public Optional<GroupUserDTO> findById(Long id) {
        return Optional.ofNullable(groupUserMapper.opToDTO(groupUserRepository.findById(id)));
    }

    @Override
    public List<GroupUserDTO> findAll() {
        return groupUserRepository.findAll().stream().map(groupUserMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<GroupUserDTO> page(Pageable pageable) {
        return groupUserRepository.findAll(pageable).map(groupUserMapper::toDTO);
    }
}
