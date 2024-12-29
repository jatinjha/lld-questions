package com.jatin.parkinglot;

import com.jatin.parkinglot.enums.VEHICLE_TYPE;
import com.jatin.parkinglot.model.*;
import com.jatin.parkinglot.service.BikeParkingSpotManager;
import com.jatin.parkinglot.service.CarParkingSpotManager;
import com.jatin.parkinglot.service.ParkingSpotManager;
import com.jatin.parkinglot.service.factory.ParkingSpotManagerFactory;
import com.jatin.parkinglot.service.stategy.HourlyPaymentStrategy;
import com.jatin.parkinglot.service.stategy.NaturalParking;


public class ParkingLotDriver {

    public static void main(String[] args) {
        System.out.println("parking lot program");

        Car car1 = new Car("dl124rt");
        Bike bike1 = new Bike("dl123rtv");
        Car car2 = new Car("rj123rt4");
        Car car3 = new Car("rj123rt43c");
        Bike bike2 = new Bike("dl123rtv2");
        Bike bike3 = new Bike("dl123rtv3");
        ParkingSpotManager carParkingSpotManager = new CarParkingSpotManager(new NaturalParking());
        ParkingSpotManager bikeParkingSpotManager = new BikeParkingSpotManager(new NaturalParking());

        EntranceGate entranceGate = new EntranceGate(1);
        try{
            ParkingTicket car1ParkingTicket = entranceGate.generateParkingTicket(car1,carParkingSpotManager);
            ParkingTicket car2ParkingTicket = entranceGate.generateParkingTicket(car2,carParkingSpotManager);
            entranceGate.generateParkingTicket(bike1,bikeParkingSpotManager);

            ExitGate exitGate = new ExitGate(1,new HourlyPaymentStrategy());
            System.out.println("cost of parking car 1 : "+exitGate.getCostOfParking(car1ParkingTicket,carParkingSpotManager));
            System.out.println("cost of parking car 2 : "+exitGate.getCostOfParking(car2ParkingTicket,carParkingSpotManager));

            ParkingTicket car3ParkingTicket = entranceGate.generateParkingTicket(car3,carParkingSpotManager);


        }catch (Exception ex){
            System.out.println("exception while generating ticket "+ex.getMessage());
        }
    }
}
