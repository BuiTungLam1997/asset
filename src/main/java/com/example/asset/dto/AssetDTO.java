package com.example.asset.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AssetDTO {
    private Long id;
    private String newAccessTagId;
    private String oldAccessTagId;
    private String assetNameModel;
    private int quantity;
    private String unitOfMeasurement;
    private String assetType;
    private Long userId;
    private String day;
    private String inventory;
    private String status;
    private String mac;
    private String serviceProvider;
    private String statusUpdate;
    private LocalDate purchaseDate;
    private String level;
    private String expectedLifeCycle;
    private String originalCost;
    private String depreciationValue;
    private String expiredLifeCycleDate;
    private String account;
    private String sapId;
    private String remainingAssetValue;
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExpectedLifeCycle() {
        return expectedLifeCycle;
    }

    public void setExpectedLifeCycle(String expectedLifeCycle) {
        this.expectedLifeCycle = expectedLifeCycle;
    }

    public String getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(String originalCost) {
        this.originalCost = originalCost;
    }

    public String getDepreciationValue() {
        return depreciationValue;
    }

    public void setDepreciationValue(String depreciationValue) {
        this.depreciationValue = depreciationValue;
    }

    public String getExpiredLifeCycleDate() {
        return expiredLifeCycleDate;
    }

    public void setExpiredLifeCycleDate(String expiredLifeCycleDate) {
        this.expiredLifeCycleDate = expiredLifeCycleDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSapId() {
        return sapId;
    }

    public void setSapId(String sapId) {
        this.sapId = sapId;
    }

    public String getRemainingAssetValue() {
        return remainingAssetValue;
    }

    public void setRemainingAssetValue(String remainingAssetValue) {
        this.remainingAssetValue = remainingAssetValue;
    }
}

