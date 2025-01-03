package com.jatin.carrental.models;

import com.jatin.carrental.enums.ReservationStatus;
import com.jatin.carrental.enums.ReservationType;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFrom;
    private Date dateBookedTo;
    private Location pickUpLocation;
    private Location dropLocation;
    private ReservationType reservationType;
    ReservationStatus reservationStatus;
    private Location location;

    private Reservation(ReservationBuilder reservationBuilder){
        this.reservationId = reservationBuilder.id;
        this.user = reservationBuilder.user;
        this.vehicle = reservationBuilder.vehicle;
        this.dateBookedFrom = reservationBuilder.dateBookedFrom;
        this.dateBookedTo = reservationBuilder.dateBookedTo;
        this.pickUpLocation = reservationBuilder.pickUpLocation;
        this.dropLocation = reservationBuilder.dropLocation;
    }

    public String getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getDateBookedFrom() {
        return dateBookedFrom;
    }

    public Date getDateBookedTo() {
        return dateBookedTo;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setReservationType(ReservationType reservationType){
        this.reservationType  = reservationType;
    }

    public void setReservationStatus(ReservationStatus reservationStatus){
        this.reservationStatus = reservationStatus;
    }

    public static class ReservationBuilder{
        private String id;
        private User user;
        private Vehicle vehicle;
        private Date dateBookedFrom;
        private Date dateBookedTo;
        private Location pickUpLocation;
        private Location dropLocation;

        public ReservationBuilder(){
            this.id = UUID.randomUUID().toString();
        }


        public ReservationBuilder setUser(User user){
            this.user = user;
            return this;
        }

        public ReservationBuilder setVehicle(Vehicle vehicle){
            this.vehicle = vehicle;
            return this;
        }

        public ReservationBuilder setDateBookedFrom(Date dateBookedFrom){
            this.dateBookedFrom = dateBookedFrom;
            return this;
        }

        public ReservationBuilder setDateBookedTo(Date dateBookedTo){
            this.dateBookedTo = dateBookedTo;
            return this;
        }
        public ReservationBuilder setPickUpLocation(Location pickUpLocation){
            this.pickUpLocation = pickUpLocation;
            return this;
        }
        public ReservationBuilder setDropLocation(Location dropLocation){
            this.dropLocation = dropLocation;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }

}
