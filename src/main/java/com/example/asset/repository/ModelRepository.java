package com.example.asset.repository;

import com.example.asset.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity,Long> {
}
