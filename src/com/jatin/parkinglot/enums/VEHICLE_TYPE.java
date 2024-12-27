package com.jatin.parkinglot.enums;

public enum VEHICLE_TYPE {
    Car("car"),
    Truck("truck"),
    MotorCycle("motorcycle");
    private final String displayName;
    VEHICLE_TYPE(String name){
        displayName = name;
    }
}
