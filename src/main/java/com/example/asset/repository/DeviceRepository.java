package com.example.asset.repository;

import com.example.asset.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceEntity,Long> {
}
