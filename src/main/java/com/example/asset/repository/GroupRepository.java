package com.example.asset.repository;

import com.example.asset.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity,Long> {
}
