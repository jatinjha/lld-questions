package com.jatin.parkinglot.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ParkingTicket {
    private Date parkTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

    public ParkingTicket(Date parkTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.parkTime = parkTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public Date getParkTime() {
        return parkTime;
    }

    public void setParkTime(Date totalTime) {
        this.parkTime = totalTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public long getParkingDuration(){
        Date currentDate = new Date();
        long parkDuration = currentDate.getTime()-parkTime.getTime()+3l;
        return TimeUnit.MILLISECONDS.toHours(parkDuration);
    }
}
