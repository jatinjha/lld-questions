package com.jatin.carrental.models;

import java.util.ArrayList;
import java.util.List;

public class Store {
    String id;
    List<Vehicle> vehicleList;

    public Store(){
        vehicleList = new ArrayList<>();
    }

    public void addVehicles(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public List<Vehicle> getAllVechilesInStore(){
        return vehicleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
