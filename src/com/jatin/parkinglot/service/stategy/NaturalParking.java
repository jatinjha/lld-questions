package com.jatin.parkinglot.service.stategy;

import com.jatin.parkinglot.model.ParkingSpot;

import java.util.TreeSet;

public class NaturalParking implements ParkingStrategy{

    TreeSet<ParkingSpot> parkingOrderSet = new TreeSet<ParkingSpot>((spot1,spot2)->
            (spot1.getParkingSpotId().compareTo(spot2.getParkingSpotId())));
    @Override
    public String findParkingSpotId() {
        for(ParkingSpot parkingSpot : parkingOrderSet){
            if(Boolean.TRUE.equals(parkingSpot.getSpotAvailable())){
                return parkingSpot.getParkingSpotId();
            }
        }
        return "";
    }

    @Override
    public String addParkingSpot(ParkingSpot parkingSpot) {
        parkingOrderSet.add(parkingSpot);
        return parkingSpot.getParkingSpotId();
    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpotId) {
        parkingOrderSet.remove(parkingSpotId);
    }
}
