package com.example.asset.mapper;

import com.example.asset.dto.ModelDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.entity.ModelEntity;
import com.example.asset.entity.UserEntity;
import org.mapstruct.Mapper;
import org.slf4j.MDC;
import org.springframework.ui.Model;

@Mapper(componentModel = "spring")
public interface ModelMapper extends CommonMapper<ModelDTO, ModelEntity> {
}
