package com.jatin.parkinglot.service;

import com.jatin.parkinglot.model.ParkingSpot;
import com.jatin.parkinglot.model.Vehicle;

import java.util.Optional;

public interface ParkingSpotManager {
    public Optional<ParkingSpot> findParkingSpot();
    public void addParkingSpot();
    public void removeParkingSpace(String parkingSpotId);
    public void parkAVehicle(ParkingSpot parkingSpot , Vehicle vehicle) throws Exception;
    public void removeAVehicle(ParkingSpot parkingSpot) throws Exception;
}
