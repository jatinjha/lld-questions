package com.jatin.parkinglot.enums;

public enum PARKING_SPOT_TYPE {
    CarParking("car parking"),
    Bike("bike parking"),
    TruckParking("truck parking");
    private final String displayName;
    PARKING_SPOT_TYPE(String name){
        this.displayName = name;
    }
}
