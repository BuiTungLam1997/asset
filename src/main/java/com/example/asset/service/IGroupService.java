package com.example.asset.service;

import com.example.asset.dto.GroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGroupService {
    GroupDTO insert(GroupDTO groupDTO);

    GroupDTO update(GroupDTO groupDTO);

    void delete(List<Long> ids);

    Optional<GroupDTO> findById(Long id);

    List<GroupDTO> findAll();

    Page<GroupDTO> findAll(Pageable pageable);
}
