package com.jatin.parkinglot.service.stategy;

public class HourlyPaymentStrategy implements PaymentStrategy{
    @Override
    public double getParkingPrice(double price , long parkingDuration) {
        return price*parkingDuration;
    }
}
