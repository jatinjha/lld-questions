package com.jatin.parkinglot.service.factory;

import com.jatin.parkinglot.enums.VEHICLE_TYPE;
import com.jatin.parkinglot.service.BikeParkingSpotManager;
import com.jatin.parkinglot.service.CarParkingSpotManager;
import com.jatin.parkinglot.service.ParkingSpotManager;
import com.jatin.parkinglot.service.stategy.NaturalParking;

import java.util.ArrayList;

public class ParkingSpotManagerFactory {
    public static ParkingSpotManager getParkingSpotManager(VEHICLE_TYPE vehicle_type){
        switch (vehicle_type){
            case Car:
                return new CarParkingSpotManager(new NaturalParking());
            default:
                return new BikeParkingSpotManager(new NaturalParking());
        }
    }
}
