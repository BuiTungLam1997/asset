package com.example.asset.service.impl;

import com.example.asset.dto.UserDTO;
import com.example.asset.mapper.UserMapper;
import com.example.asset.repository.UserRepository;
import com.example.asset.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDTO);

    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO insert(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        userRepository.deleteAllById(ids);
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    @Override
    public Page<UserDTO> search(Pageable pageable, String search) {
        return userRepository.search(pageable, search).map(userMapper::toDTO);
    }
}
