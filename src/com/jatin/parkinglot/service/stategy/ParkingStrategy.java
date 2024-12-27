package com.jatin.parkinglot.service.stategy;

import com.jatin.parkinglot.model.ParkingSpot;

public interface ParkingStrategy {
    public String findParkingSpotId();
    public String addParkingSpot(String parkingSpotId);
    public void removeParkingSpot(String parkingSpotId);
}
