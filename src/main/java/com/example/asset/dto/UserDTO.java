package com.example.asset.dto;

import lombok.Getter;

import java.time.LocalDate;


public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String legalEntity;
    private String location;
    private String site;
    private String status;
    private LocalDate lastWorkingDate;
    private String jobPosition;
    private Integer level;
    private String fullName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastWorkingDate(LocalDate lastWorkingDate) {
        this.lastWorkingDate = lastWorkingDate;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public String getLocation() {
        return location;
    }

    public String getSite() {
        return site;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getLastWorkingDate() {
        return lastWorkingDate;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public Integer getLevel() {
        return level;
    }

    public String getFullName() {
        return fullName;
    }
}
