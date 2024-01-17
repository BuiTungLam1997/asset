package com.example.asset.service;

import com.example.asset.dto.PermissionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    PermissionDTO insert(PermissionDTO permissionDTO);

    PermissionDTO update(PermissionDTO permissionDTO);

    void delete(List<Long> ids);

    Optional<PermissionDTO> findById(Long id);

    List<PermissionDTO> findAll();

    Page<PermissionDTO> page(Pageable pageable);
}
