package com.example.asset.service.impl;

import com.example.asset.dto.DeviceDTO;
import com.example.asset.mapper.DeviceMapper;
import com.example.asset.repository.DeviceRepository;
import com.example.asset.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService implements IDeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public DeviceDTO insert(DeviceDTO deviceDTO) {
        return deviceMapper.toDTO(deviceRepository.save(deviceMapper.toEntity(deviceDTO)));
    }

    @Override
    public DeviceDTO update(DeviceDTO deviceDTO) {
        return deviceMapper.toDTO(deviceRepository.save(deviceMapper.toEntity(deviceDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        deviceRepository.deleteAllById(ids);
    }

    @Override
    public Optional<DeviceDTO> findById(Long id) {
        return Optional.ofNullable(deviceMapper.opToDTO(deviceRepository.findById(id)));
    }

    @Override
    public List<DeviceDTO> findAll() {
        return deviceRepository.findAll().stream().map(deviceMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<DeviceDTO> page(Pageable pageable) {
        return deviceRepository.findAll(pageable).map(deviceMapper::toDTO);
    }
}
