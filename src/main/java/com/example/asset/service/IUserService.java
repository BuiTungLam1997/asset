package com.example.asset.service;


import com.example.asset.dto.DeviceDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Page<UserDTO> findAll(Pageable pageable);
    List<UserDTO> findAll();
    UserDTO insert(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    void delete(List<Long> ids);

    Optional<UserDTO> findById(Long id);

    Page<UserDTO> search(Pageable pageable,String search);
}
