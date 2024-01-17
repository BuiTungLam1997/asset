package com.example.asset.repository;

import com.example.asset.entity.GroupUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupUserRepository extends JpaRepository<GroupUserEntity,Long> {
}
