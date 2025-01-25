package com.jatin.inventorymanagmentsystem.services;

import com.jatin.carrental.models.Location;
import com.jatin.inventorymanagmentsystem.models.WareHouse;
import com.jatin.inventorymanagmentsystem.services.strategy.WareHouseSelectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WareHouseManagerService {
    WareHouseSelectionStrategy wareHouseSelectionStrategy;

    public WareHouseManagerService(WareHouseSelectionStrategy wareHouseSelectionStrategy){
        this.wareHouseSelectionStrategy = wareHouseSelectionStrategy;
    }

    public void addWareHouse(WareHouse wareHouse , Location location){
        wareHouseSelectionStrategy.addWareHouse(wareHouse,location);
    }

    public List<WareHouse> getAllWareHouse(Location location){
        return wareHouseSelectionStrategy.getAllWareHouse(location);
    }

    public WareHouse getWareHouse(Location location){
        return wareHouseSelectionStrategy.getWareHouse(location);
    }




 }
