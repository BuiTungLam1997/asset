package com.example.asset.mapper;

import com.example.asset.dto.PermissionDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.entity.PermissionEntity;
import com.example.asset.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends CommonMapper<PermissionDTO, PermissionEntity> {
}
