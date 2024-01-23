package com.example.asset.service;

import com.example.asset.dto.GroupUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGroupUserService {
    GroupUserDTO insert(GroupUserDTO groupUserDTO);

    GroupUserDTO update(GroupUserDTO groupUserDTO);

    void delete(List<Long> ids);

    Optional<GroupUserDTO> findById(Long id);

    List<GroupUserDTO> findAll();

    Page<GroupUserDTO> page(Pageable pageable);
}
