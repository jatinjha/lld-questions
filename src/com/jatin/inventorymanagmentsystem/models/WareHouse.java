package com.jatin.inventorymanagmentsystem.models;

import com.jatin.carrental.models.Location;
import com.jatin.inventorymanagmentsystem.services.InventoryService;

public class WareHouse {
    String id;
    InventoryService inventoryService;
    Location address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }
}
