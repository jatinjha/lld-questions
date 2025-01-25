package com.jatin.inventorymanagmentsystem.services.strategy;

import com.jatin.inventorymanagmentsystem.models.ProductCategory;
import com.jatin.inventorymanagmentsystem.models.Seller;
import com.jatin.inventorymanagmentsystem.models.WareHouse;
import com.jatin.inventorymanagmentsystem.services.InventoryService;

import java.util.List;
import java.util.stream.Collectors;

public class InternalInventoryManagementStrategy implements InventoryManagementStrategy{
    @Override
    public void addItemToInventory(Seller seller, ProductCategory productCategory) {
        WareHouse wareHouse = seller.getWareHouse();
        InventoryService inventoryService = wareHouse.getInventoryService();
        List<ProductCategory> productCategoryList = inventoryService.getProductCategoryList();;
        productCategoryList.add(productCategory);
    }

    @Override
    public List<ProductCategory> getAvailableInventory(String productCategoryId, Seller seller) {
        WareHouse wareHouse = seller.getWareHouse();
        InventoryService inventoryService = wareHouse.getInventoryService();
        return inventoryService.getProductCategoryList().stream().filter(productCategory -> productCategory.getProductCategoryId().equals(productCategoryId)).collect(Collectors.toList());
    }

    @Override
    public void removeItemFromInventory(String productCategoryId, Seller seller) {
        WareHouse wareHouse = seller.getWareHouse();
        InventoryService inventoryService = wareHouse.getInventoryService();
        inventoryService.getProductCategoryList().removeIf(productCategory -> productCategory.getProductCategoryId().equals(productCategoryId));
    }
}
