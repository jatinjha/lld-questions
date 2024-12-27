package com.jatin.parkinglot.model;
import com.jatin.parkinglot.enums.VEHICLE_TYPE;

public class Vehicle {
    VEHICLE_TYPE vehicleType;
    String registrationId;

    public Vehicle(VEHICLE_TYPE vehicleType, String registrationId) {
        this.vehicleType = vehicleType;
        this.registrationId = registrationId;
    }

    public VEHICLE_TYPE getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VEHICLE_TYPE vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
