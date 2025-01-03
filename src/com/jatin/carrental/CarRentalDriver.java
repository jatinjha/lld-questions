package com.jatin.carrental;

import com.jatin.carrental.enums.VehicleType;
import com.jatin.carrental.factory.PaymentFactory;
import com.jatin.carrental.models.*;
import com.jatin.carrental.services.PaymentManagementService;
import com.jatin.carrental.services.ReservationManagementService;
import com.jatin.carrental.services.VehicleInventoryManagementService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CarRentalDriver {

    public static void main(String[] args) {
        User userOne = new User("a","dl121");
        User userTwo = new User("b","dl123");
        Store storeOne = new Store();
        storeOne.setId("store1");

        Store storeTwo = new Store();
        storeOne.setId("store2");

        Store storeThree = new Store();
        storeOne.setId("store3");

        Vehicle vehicleOne = new Vehicle();
        vehicleOne.setVehicleID(12123213);
        vehicleOne.setVehicleType(VehicleType.CAR);
        vehicleOne.setHourlyRentalCost(10);


        Vehicle vehicleTwo = new Vehicle();
        vehicleTwo.setVehicleID(22123213);
        vehicleOne.setVehicleType(VehicleType.CAR);
        vehicleOne.setHourlyRentalCost(13);


        VehicleInventoryManagementService vims = new VehicleInventoryManagementService();
        vims.addVehicleInStore(storeOne,vehicleOne);
        vims.addVehicleInStore(storeTwo,vehicleTwo);

        Location location1 = new Location(21212,"delhi","delhi","india");
        Location location2 = new Location(11212,"mumbai","mumbai","india");

        vims.addStoreAtLocation(location1,storeOne);
        vims.addStoreAtLocation(location2,storeTwo);



        List<Store> storeList = vims.getListOfStoresByLocation(location1);
        Store store = storeList.get(0);
        Vehicle vehicle = store.getAllVechilesInStore().get(0);
        ReservationManagementService reservationManagementService = new ReservationManagementService();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 10, 10, 30, 45); // 15th Jan 2025, 10:30:45 AM
        Date specificDateWithTime = calendar.getTime();

        String reservationId = reservationManagementService.reserveVehicle(userOne,vehicle,new Date(),specificDateWithTime, location1,location2);

        Optional<Reservation> reservationByUserOne = reservationManagementService.getReservationById(reservationId);

        if(reservationByUserOne.isEmpty()){
            System.out.println("invalid reservation Id");
            return;
        }

        PaymentManagementService paymentManagementService = new PaymentManagementService();
        paymentManagementService.doPayment(reservationByUserOne.get(), PaymentFactory.getPaymentMode("COD"));

    }
}
