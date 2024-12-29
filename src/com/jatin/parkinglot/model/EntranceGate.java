package com.jatin.parkinglot.model;

import com.jatin.parkinglot.service.ParkingSpotManager;
import com.jatin.parkinglot.service.factory.ParkingSpotManagerFactory;

import java.util.Date;
import java.util.Optional;

public class EntranceGate {
    int entranceGateNumber;


    public EntranceGate(int entranceGateNumber) {
        this.entranceGateNumber = entranceGateNumber;
    }

    public ParkingTicket generateParkingTicket(Vehicle vehicle , ParkingSpotManager parkingSpotManager) throws Exception {
        Optional<ParkingSpot> parkingSpot = parkingSpotManager.findParkingSpot();
        if(parkingSpot.isEmpty()){
            System.out.println("parking not available");
            throw new Exception("parking not availalbe");
        }
        parkingSpotManager.parkAVehicle(parkingSpot.get(),vehicle);
        ParkingTicket parkingTicket = new ParkingTicket(new Date(),vehicle,parkingSpot.get());
        return parkingTicket;
    }
}
