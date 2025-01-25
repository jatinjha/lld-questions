package com.jatin.inventorymanagmentsystem.factory;

import com.jatin.inventorymanagmentsystem.models.User;

import java.util.UUID;

public class InventoryFactory {
    public static User getUser(String name){
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName(name);
        return user;
    }

}
