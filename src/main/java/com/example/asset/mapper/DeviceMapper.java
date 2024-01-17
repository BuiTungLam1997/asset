package com.example.asset.mapper;

import com.example.asset.dto.DeviceDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.entity.DeviceEntity;
import com.example.asset.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper extends CommonMapper<DeviceDTO, DeviceEntity> {
}
