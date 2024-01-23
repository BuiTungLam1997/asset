package com.example.asset.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "group_permission")

public class GroupPermissionEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long groupId;
    @Column
    private Long permissionId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getPermissionId() {
        return permissionId;
    }
}
