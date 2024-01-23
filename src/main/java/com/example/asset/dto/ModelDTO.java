package com.example.asset.dto;

import lombok.Data;
import lombok.Getter;



public class ModelDTO   {
    private Long id;
    private String name;
    private String code;
    private String detail;
    private String note;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getDetail() {
        return detail;
    }

    public String getNote() {
        return note;
    }
}
