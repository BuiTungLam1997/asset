package com.example.asset.mapper;

import com.example.asset.dto.GroupDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.entity.GroupEntity;
import com.example.asset.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper extends CommonMapper<GroupDTO, GroupEntity> {
}
