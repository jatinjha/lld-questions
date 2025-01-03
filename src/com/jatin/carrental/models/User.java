package com.jatin.carrental.models;


import java.util.UUID;

public class User {

    String userId;
    String userName;
    String drivingLicense;

    public User(String userName , String drivingLicense){
        this.userName = userName;
        this.drivingLicense = drivingLicense;
        this.userId = UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}

