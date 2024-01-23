package com.example.asset.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "permission")

public class PermissionEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String code;
    @Column
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
