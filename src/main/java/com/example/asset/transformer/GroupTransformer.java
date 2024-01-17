package com.example.asset.transformer;

import com.example.asset.dto.GroupDTO;
import com.example.asset.entity.GroupEntity;
import org.modelmapper.ModelMapper;

public class GroupTransformer extends CommonTransformer<GroupDTO, GroupEntity> {
    public GroupTransformer(ModelMapper modelMapper) {
        super(GroupDTO.class, GroupEntity.class, modelMapper);
    }
}
