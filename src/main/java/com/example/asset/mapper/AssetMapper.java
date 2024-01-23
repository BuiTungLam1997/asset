package com.example.asset.mapper;

import com.example.asset.dto.AssetDTO;
import com.example.asset.entity.AssetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetMapper extends CommonMapper<AssetDTO, AssetEntity> {
}
