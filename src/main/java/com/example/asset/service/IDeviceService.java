package com.example.asset.service;

import com.example.asset.dto.DeviceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDeviceService {
    DeviceDTO insert(DeviceDTO deviceDTO);

    DeviceDTO update(DeviceDTO deviceDTO);

    void delete(List<Long> ids);

    Optional<DeviceDTO> findById(Long id);
    List<DeviceDTO> findAll() ;
    Page<DeviceDTO> page(Pageable pageable) ;

}
