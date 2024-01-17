package com.example.asset.dto;

import lombok.Getter;

import java.time.LocalDate;

public class DeviceDTO {
    private Long id;
    private String newAccessTagId;
    private String oldAccessTagId;
    private String assetNameModel;
    private int quantity;
    private String unitOfMeasurement;
    private String assetType;
    private Long userId;
    private LocalDate day;
    private String inventory;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewAccessTagId() {
        return newAccessTagId;
    }

    public void setNewAccessTagId(String newAccessTagId) {
        this.newAccessTagId = newAccessTagId;
    }

    public String getOldAccessTagId() {
        return oldAccessTagId;
    }

    public void setOldAccessTagId(String oldAccessTagId) {
        this.oldAccessTagId = oldAccessTagId;
    }

    public String getAssetNameModel() {
        return assetNameModel;
    }

    public void setAssetNameModel(String assetNameModel) {
        this.assetNameModel = assetNameModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

