package com.example.asset.transformer;

import com.example.asset.dto.DeviceDTO;
import com.example.asset.entity.DeviceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceTransformer extends CommonTransformer<DeviceDTO, DeviceEntity> {
    public DeviceTransformer(ModelMapper modelMapper) {
        super(DeviceDTO.class, DeviceEntity.class, modelMapper);
    }
}
