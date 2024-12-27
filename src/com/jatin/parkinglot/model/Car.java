package com.jatin.parkinglot.model;

import com.jatin.parkinglot.enums.VEHICLE_TYPE;

public class Car extends Vehicle{
    public Car(String registrationId) {
        super(VEHICLE_TYPE.Car, registrationId);
    }
}
