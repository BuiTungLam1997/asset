package com.example.asset.service;

import com.example.asset.dto.DeviceDTO;
import com.example.asset.dto.GroupPermissionDTO;
import com.example.asset.dto.PermissionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGroupPermissionService {
    GroupPermissionDTO insert(GroupPermissionDTO groupPermissionDTO);

    GroupPermissionDTO update(GroupPermissionDTO groupPermissionDTO);

    void delete(List<Long> ids);

    Optional<GroupPermissionDTO> findById(Long id);

    List<GroupPermissionDTO> findAll();

    Page<GroupPermissionDTO> page(Pageable pageable);
}
