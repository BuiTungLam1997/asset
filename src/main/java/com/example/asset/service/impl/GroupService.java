package com.example.asset.service.impl;

import com.example.asset.dto.GroupDTO;
import com.example.asset.mapper.GroupMapper;
import com.example.asset.repository.GroupRepository;
import com.example.asset.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService implements IGroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    GroupMapper groupMapper;

    @Override
    public GroupDTO insert(GroupDTO groupDTO) {
        return groupMapper.toDTO(groupRepository.save(groupMapper.toEntity(groupDTO)));
    }

    @Override
    public GroupDTO update(GroupDTO groupDTO) {
        return groupMapper.toDTO(groupRepository.save(groupMapper.toEntity(groupDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        groupRepository.deleteAllById(ids);
    }

    @Override
    public Optional<GroupDTO> findById(Long id) {
        return Optional.ofNullable(groupMapper.opToDTO(groupRepository.findById(id)));
    }

    @Override
    public List<GroupDTO> findAll() {
        return groupRepository.findAll().stream().map(groupMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<GroupDTO> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable).map(groupMapper::toDTO);
    }
}
