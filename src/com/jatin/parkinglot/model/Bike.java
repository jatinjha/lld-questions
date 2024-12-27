package com.jatin.parkinglot.model;

import com.jatin.parkinglot.enums.VEHICLE_TYPE;

public class Bike extends Vehicle{
    public Bike(String registrationId) {
        super(VEHICLE_TYPE.MotorCycle, registrationId);
    }
}
