package com.jatin.inventorymanagmentsystem.services.strategy;

import com.jatin.carrental.models.Location;
import com.jatin.inventorymanagmentsystem.models.WareHouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestWareHouseSelectionStrategy implements WareHouseSelectionStrategy{

    // use tree map with map based location sorting
    Map<Location,List<WareHouse>> locationVsWareHouse;

    public NearestWareHouseSelectionStrategy(){
        locationVsWareHouse = new HashMap<>();
    }

    @Override
    public WareHouse getWareHouse(Location location) {
        //replace with actual custom sorting
        return locationVsWareHouse.get(location).get(0);
    }

    @Override
    public void addWareHouse(WareHouse wareHouse,Location location) {
        locationVsWareHouse.computeIfAbsent(location,key->new ArrayList<>()).add(wareHouse);
    }

    @Override
    public List<WareHouse> getAllWareHouse(Location location) {
        return locationVsWareHouse.getOrDefault(location,new ArrayList<>());
    }
}
