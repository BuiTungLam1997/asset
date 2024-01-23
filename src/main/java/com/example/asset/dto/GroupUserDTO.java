package com.example.asset.dto;

import lombok.Data;
import lombok.Getter;



public class GroupUserDTO {
    private Long id;
    private Long groupId;
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getUserId() {
        return userId;
    }
}
