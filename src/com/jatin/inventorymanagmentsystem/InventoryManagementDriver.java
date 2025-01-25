package com.jatin.inventorymanagmentsystem;

import com.jatin.carrental.models.Location;
import com.jatin.inventorymanagmentsystem.factory.InventoryFactory;
import com.jatin.inventorymanagmentsystem.models.*;
import com.jatin.inventorymanagmentsystem.services.InventoryService;
import com.jatin.inventorymanagmentsystem.services.UserService;
import com.jatin.inventorymanagmentsystem.services.WareHouseManagerService;
import com.jatin.inventorymanagmentsystem.services.strategy.NearestWareHouseSelectionStrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class InventoryManagementDriver {
    public static void main(String[] args) {
        System.out.println("program started ");
        User user1 = InventoryFactory.getUser("user1");
        User user2 = InventoryFactory.getUser("user2");
        User user3 = InventoryFactory.getUser("user3");

        UserService userService = new UserService();
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        Product parleg1 = new Product(UUID.randomUUID().toString(),"parleg1");
        Product parleg2 = new Product(UUID.randomUUID().toString(),"parleg2");

        Product coke1 = new Product(UUID.randomUUID().toString(),"coke1");

        Product coke2 = new Product(UUID.randomUUID().toString(),"coke2");


        Product bread = new Product(UUID.randomUUID().toString(),"bread");

        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryId(UUID.randomUUID().toString());
        productCategory1.setProductList(List.of(parleg1,parleg2));
        productCategory1.setPrice(BigDecimal.valueOf(10l));

        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryId(UUID.randomUUID().toString());
        productCategory2.setProductList(List.of(coke1,coke2));
        productCategory2.setPrice(BigDecimal.valueOf(40l));

        ProductCategory productCategory3 = new ProductCategory();
        productCategory3.setProductCategoryId(UUID.randomUUID().toString());
        productCategory3.setProductList(List.of(bread));
        productCategory3.setPrice(BigDecimal.valueOf(45));


        InventoryService inventoryServiceInternal = new InventoryService();
        inventoryServiceInternal.setProductCategoryList(List.of(productCategory1,productCategory2));


        InventoryService inventoryServiceExternal = new InventoryService();
        inventoryServiceExternal.setProductCategoryList(List.of(productCategory3));

        WareHouse wareHouseInternal = new WareHouse();
        WareHouse wareHouseExternal = new WareHouse();


        Location location1 = new Location(21,"Delhi","Delhi","India");
        Location location2 = new Location(41,"Numbai","Numbai","India");


        wareHouseExternal.setId("ware1");
        wareHouseInternal.setId("ware2");
        wareHouseExternal.setAddress(location1);
        wareHouseExternal.setAddress(location2);
        wareHouseExternal.setInventoryService(inventoryServiceExternal);
        wareHouseInternal.setInventoryService(inventoryServiceInternal);
        Seller fkart = new Seller();
        fkart.setName("fkart");
        fkart.setIsInternal(true);
        fkart.setWareHouse(wareHouseInternal);

        Seller ecomm = new Seller();
        ecomm.setName("ecomm");
        ecomm.setIsInternal(false);
        ecomm.setWareHouse(wareHouseExternal);

        WareHouseManagerService wareHouseManagerService = new WareHouseManagerService(new NearestWareHouseSelectionStrategy());
        wareHouseManagerService.addWareHouse(wareHouseExternal,location1);
        wareHouseManagerService.addWareHouse(wareHouseInternal,location2);




    }
}
