package com.example.asset.transformer;

import com.example.asset.dto.GroupPermissionDTO;
import com.example.asset.entity.GroupPermissionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GroupPermissionTransformer extends CommonTransformer<GroupPermissionDTO, GroupPermissionEntity> {
    public GroupPermissionTransformer(ModelMapper modelMapper) {
        super(GroupPermissionDTO.class, GroupPermissionEntity.class, modelMapper);
    }
}
