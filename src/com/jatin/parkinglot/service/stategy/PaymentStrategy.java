package com.jatin.parkinglot.service.stategy;

public interface PaymentStrategy {
    double getParkingPrice(double price , long parkingDuration);
}
