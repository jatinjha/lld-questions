package com.jatin.carrental.services;

import com.jatin.carrental.enums.ReservationStatus;
import com.jatin.carrental.factory.PaymentFactory;
import com.jatin.carrental.models.PaymentMode;
import com.jatin.carrental.models.Reservation;
import com.jatin.carrental.models.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class PaymentManagementService {
    public void doPayment(Reservation reservation, PaymentMode paymentMode){
        Vehicle vehicle = reservation.getVehicle();
        double totalCost = 0d;
        if(reservation.getReservationStatus().equals(ReservationStatus.COMPLETED)){
            double pricePerHour = vehicle.getHourlyRentalCost();

            LocalDateTime dateTime1 = reservation.getDateBookedFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime dateTime2 = reservation.getDateBookedTo().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            Duration duration = Duration.between(dateTime1,dateTime2);
            totalCost = pricePerHour*duration.toHours();
        }

        if(totalCost == 0d){
            System.out.println("no outstanding amount");
            return;
        }

        paymentMode.payBill();
    }
}
