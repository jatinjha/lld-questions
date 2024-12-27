package com.jatin.parkinglot.model;

import com.jatin.parkinglot.enums.PARKING_SPOT_TYPE;

public class ParkingSpot {
    String parkingSpotId;
    Boolean isSpotAvailable;
    Vehicle vehicle;
    PARKING_SPOT_TYPE parkingSpotType;

    public ParkingSpot(String parkingSpotId , PARKING_SPOT_TYPE parkingSpotType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
    }

    public Boolean getSpotAvailable() {
        return isSpotAvailable;
    }

    public void setSpotAvailable(Boolean spotAvailable) {
        isSpotAvailable = spotAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void parkVehicle(Vehicle vehicle){
        setVehicle(vehicle);
        setSpotAvailable(false);
    }

    public void unParkVehicle(){
        setVehicle(null);
        setSpotAvailable(true);
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }


    public PARKING_SPOT_TYPE getParkingSpotType() {
        return parkingSpotType;
    }

}
