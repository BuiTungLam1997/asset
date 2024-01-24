package com.example.asset.service.impl;

import com.example.asset.dto.GroupDTO;
import com.example.asset.entity.GroupEntity;
import com.example.asset.mapper.GroupMapper;
import com.example.asset.repository.GroupRepository;
import com.example.asset.service.IGroupService;
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
public class GroupService implements IGroupService {


    GroupRepository groupRepository;

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
    public GroupDTO findById(Long id) {
        GroupEntity groupEntity = groupRepository.findById(id).orElseThrow(NullPointerException::new);
        return groupMapper.toDTO(groupEntity);
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
