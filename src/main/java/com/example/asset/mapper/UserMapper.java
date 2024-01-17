package com.example.asset.mapper;

import com.example.asset.dto.UserDTO;
import com.example.asset.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper extends CommonMapper<UserDTO, UserEntity> {
}
