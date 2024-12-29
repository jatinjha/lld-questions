package com.jatin.parkinglot.service;

import com.jatin.parkinglot.model.BikeParkingSpot;
import com.jatin.parkinglot.model.ParkingSpot;
import com.jatin.parkinglot.model.Vehicle;
import com.jatin.parkinglot.service.stategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BikeParkingSpotManager implements ParkingSpotManager{

    private List<ParkingSpot> parkingSpotList;
    private ParkingStrategy parkingStrategy;

    public BikeParkingSpotManager(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
        this.parkingSpotList = new ArrayList<>();
        for(int i=0 ;i<4 ; i++){
            this.addParkingSpot();
        }
    }

    @Override
    public Optional<ParkingSpot> findParkingSpot() {
        String nextAvailableSpot = parkingStrategy.findParkingSpotId();
        return parkingSpotList.stream().filter(parkingSpot -> parkingSpot.getParkingSpotId().equals(nextAvailableSpot)).findAny();
    }

    @Override
    public void addParkingSpot() {
        BikeParkingSpot bikeParkingSpot = new BikeParkingSpot();
        bikeParkingSpot.setSpotAvailable(true);
        parkingSpotList.add(bikeParkingSpot);
        parkingStrategy.addParkingSpot(bikeParkingSpot);
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
