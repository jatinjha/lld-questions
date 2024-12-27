package com.jatin.parkinglot.service;

import com.jatin.parkinglot.model.BikeParkingSpot;
import com.jatin.parkinglot.model.ParkingSpot;
import com.jatin.parkinglot.model.Vehicle;
import com.jatin.parkinglot.service.stategy.ParkingStrategy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BikeParkingSpotManager implements ParkingSpotManager{

    private final List<ParkingSpot> parkingSpotList;
    private ParkingStrategy parkingStrategy;

    public BikeParkingSpotManager(List<ParkingSpot> parkingSpotList , ParkingStrategy parkingStrategy){
        this.parkingSpotList = parkingSpotList;
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public Optional<ParkingSpot> findParkingSpot() {
        String nextAvailableSpot = parkingStrategy.findParkingSpotId();
        return parkingSpotList.stream().filter(parkingSpot -> parkingSpot.getParkingSpotId().equals(nextAvailableSpot)).findAny();
    }

    @Override
    public void addParkingSpot() {
        String parkId = UUID.randomUUID().toString();
        parkingSpotList.add(new BikeParkingSpot(parkId));
        parkingStrategy.addParkingSpot(parkId);
    }

    @Override
    public void removeParkingSpace(String parkId) {
        parkingSpotList.removeIf(parkingSpot -> parkingSpot.getParkingSpotId().equals(parkId));
    }

    @Override
    public void parkAVehicle(ParkingSpot parkingSpot, Vehicle vehicle) throws Exception{
        if(parkingSpot.getSpotAvailable()){
            parkingSpot.parkVehicle(vehicle);
        }
        else{
            System.out.println("parking spot not available ");
            throw new Exception("spot is already occupied by another bike");
        }
    }

    @Override
    public void removeAVehicle(ParkingSpot parkingSpot) throws Exception{
        if(parkingSpot.getSpotAvailable()){
            System.out.println("no bike is parked here");
            throw new Exception("no bike is parked");
        }
        parkingSpot.unParkVehicle();
    }
}
