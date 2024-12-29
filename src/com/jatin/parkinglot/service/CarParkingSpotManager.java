package com.jatin.parkinglot.service;

import com.jatin.parkinglot.model.CardParkingSpot;
import com.jatin.parkinglot.model.ParkingSpot;
import com.jatin.parkinglot.model.Vehicle;
import com.jatin.parkinglot.service.stategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarParkingSpotManager implements ParkingSpotManager{

    List<ParkingSpot> parkingSpotList;
    ParkingStrategy parkingStrategy;

    public CarParkingSpotManager(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
        this.parkingSpotList = new ArrayList<>();
        for(int i=0 ;i<2 ; i++){
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
        CardParkingSpot cardParkingSpot = new CardParkingSpot();
        cardParkingSpot.setSpotAvailable(true);
        parkingSpotList.add(cardParkingSpot);
        parkingStrategy.addParkingSpot(cardParkingSpot);
    }

    @Override
    public void removeParkingSpace(String parkingSpotId) {
        parkingSpotList.removeIf(parkingSpot -> parkingSpot.getParkingSpotId().equals(parkingSpotId));
    }

    @Override
    public void parkAVehicle(ParkingSpot parkingSpot, Vehicle vehicle) throws Exception {
        if(!parkingSpot.getSpotAvailable()){
            System.out.println("parking spot is not available ");
            throw new Exception("parking spot in not available");
        }
        parkingSpot.parkVehicle(vehicle);
    }

    @Override
    public void removeAVehicle(ParkingSpot parkingSpot) throws Exception {
        if(parkingSpot.getSpotAvailable()){
            System.out.println("no vehicle is parked at spot");
            throw new Exception("no vehicle is parked at spot");
        }
        parkingSpot.unParkVehicle();
    }
}
