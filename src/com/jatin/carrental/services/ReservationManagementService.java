package com.jatin.carrental.services;

import com.jatin.carrental.enums.ReservationStatus;
import com.jatin.carrental.models.Location;
import com.jatin.carrental.models.Reservation;
import com.jatin.carrental.models.User;
import com.jatin.carrental.models.Vehicle;

import java.util.*;

public class ReservationManagementService {
    Map<String, Reservation> userIdVsReservation;
    List<Reservation> reservations;

    public ReservationManagementService(){
        userIdVsReservation = new HashMap<>();
        reservations = new ArrayList<>();
    }

    public String reserveVehicle(User user , Vehicle vehicle , Date dateFrom , Date dateTo, Location pickUpLocation , Location dropLocation){

        Reservation reservationObj = new Reservation.ReservationBuilder().setUser(user).setVehicle(vehicle).setDateBookedFrom(dateFrom)
                .setDateBookedTo(dateTo).setDropLocation(dropLocation).setPickUpLocation(pickUpLocation).build();

        reservationObj.setReservationStatus(ReservationStatus.IN_PROGRESS);
        userIdVsReservation.put(user.getUserId(),reservationObj);
        reservations.add(reservationObj);
        return reservationObj.getReservationId();
    }

    public Optional<Reservation> getReservationById(String reservationId){
        return reservations.stream().filter(reservation -> reservation.getReservationId().equals(reservationId)).findFirst();
    }
}
