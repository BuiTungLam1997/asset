package com.example.asset.entity;

import lombok.Getter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column
    private String email;
    @Column(name = "legal_entity")
    private String legalEntity;
    @Column
    private String location;
    @Column
    private String site;
    @Column(name = "last_working_date")
    private LocalDate lastWorkingDate;
    @Column
    private String status;
    @Column(name = "job_position")
    private String jobPosition;
    @Column
    private Integer level;
    @Column(name = "full_name")
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

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setLastWorkingDate(LocalDate lastWorkingDate) {
        this.lastWorkingDate = lastWorkingDate;
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

    public LocalDate getLastWorkingDate() {
        return lastWorkingDate;
    }

    public String getStatus() {
        return status;
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
