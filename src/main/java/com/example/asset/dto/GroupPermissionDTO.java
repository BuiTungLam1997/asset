package com.example.asset.dto;


import lombok.Getter;


public class GroupPermissionDTO {
    private Long id;
    private Long groupId;
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
