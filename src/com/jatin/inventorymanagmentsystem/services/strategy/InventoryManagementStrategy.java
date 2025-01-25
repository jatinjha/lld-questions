package com.jatin.inventorymanagmentsystem.services.strategy;

import com.jatin.inventorymanagmentsystem.models.ProductCategory;
import com.jatin.inventorymanagmentsystem.models.Seller;

import java.util.List;

public interface InventoryManagementStrategy {
    public void addItemToInventory(Seller seller , ProductCategory productCategory);
    public List<ProductCategory> getAvailableInventory(String productCategoryId, Seller seller);
    public void removeItemFromInventory(String productCategoryId, Seller seller);
}
