package com.jatin.inventorymanagmentsystem.services.strategy;

import com.jatin.carrental.models.Location;
import com.jatin.inventorymanagmentsystem.models.WareHouse;

import java.util.List;

public interface WareHouseSelectionStrategy {
    public WareHouse getWareHouse(Location location);
    public void addWareHouse(WareHouse wareHouse, Location location);
    public List<WareHouse> getAllWareHouse(Location location);

}
