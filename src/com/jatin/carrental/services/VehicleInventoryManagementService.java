package com.jatin.carrental.services;

import com.jatin.carrental.models.Location;
import com.jatin.carrental.models.Store;
import com.jatin.carrental.models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleInventoryManagementService {
    List<Vehicle> vehicleList;
    Map<Location,List<Store>> locationVsListOfStores;

    public VehicleInventoryManagementService(){
        vehicleList = new ArrayList<>();
        locationVsListOfStores = new HashMap<>();
    }

    public void addStoreAtLocation(Location location , Store store){
        List<Store> storeList = locationVsListOfStores.getOrDefault(location,new ArrayList<>());
        storeList.add(store);
        locationVsListOfStores.put(location,storeList);
    }


    public void addVehicleInStore(Store store , Vehicle vehicle){
        store.addVehicles(vehicle);
    }

    public void addVehicleInSystem(Vehicle vehicle){
        vehicleList.add(vehicle);
    }


    public List<Vehicle> allAvailableVehiclesInSystem(){
        return vehicleList;
    }

    public List<Store> getListOfStoresByLocation(Location location){
        return locationVsListOfStores.getOrDefault(location,new ArrayList<>());
    }
}
