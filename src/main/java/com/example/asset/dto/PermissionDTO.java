package com.example.asset.dto;

import lombok.Data;
import lombok.Getter;


public class PermissionDTO {
    private Long id;
    private String name;
    private String code;
    private String node;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getNode() {
        return node;
    }
}
