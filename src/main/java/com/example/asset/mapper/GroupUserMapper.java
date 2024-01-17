package com.example.asset.mapper;

import com.example.asset.dto.GroupUserDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.entity.GroupUserEntity;
import com.example.asset.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupUserMapper extends CommonMapper<GroupUserDTO, GroupUserEntity> {
}
