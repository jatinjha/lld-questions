package com.jatin.parkinglot.model;

import com.jatin.parkinglot.service.ParkingSpotManager;
import com.jatin.parkinglot.service.factory.ParkingSpotManagerFactory;
import com.jatin.parkinglot.service.stategy.PaymentStrategy;

public class ExitGate {
    private int exitGateId;
    PaymentStrategy paymentStrategy;

    public ExitGate(int exitGateId , PaymentStrategy paymentStrategy) {
        this.exitGateId = exitGateId;
        this.paymentStrategy = paymentStrategy;
    }

    public double getCostOfParking(ParkingTicket parkingTicket) throws Exception {
        ParkingSpotManager parkingSpotManager = ParkingSpotManagerFactory.getParkingSpotManager(parkingTicket.getVehicle().vehicleType);
        parkingSpotManager.removeAVehicle(parkingTicket.getParkingSpot());
        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        return paymentStrategy.getParkingPrice(parkingSpot.getParkingPrice(),parkingTicket.getParkingDuration());
    }

}
