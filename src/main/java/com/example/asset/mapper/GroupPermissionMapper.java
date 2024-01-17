package com.example.asset.mapper;

import com.example.asset.dto.GroupPermissionDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.entity.GroupPermissionEntity;
import com.example.asset.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupPermissionMapper extends CommonMapper<GroupPermissionDTO, GroupPermissionEntity> {
}
