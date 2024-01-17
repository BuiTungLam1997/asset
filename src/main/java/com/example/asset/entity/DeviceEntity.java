package com.example.asset.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "device")
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String newAccessTagId;
    @Column
    private String oldAccessTagId;
    @Column
    private String assetNameModel;
    @Column
    private int quantity;
    @Column
    private String unitOfMeasurement;
    @Column
    private String assetType;
    @Column
    private Long userId;
    @Column
    private LocalDate day;
    @Column
    private String inventory;
    @Column
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
