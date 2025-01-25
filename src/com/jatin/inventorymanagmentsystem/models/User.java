package com.jatin.inventorymanagmentsystem.models;

import com.jatin.carrental.models.Location;

import java.util.List;
import java.util.Map;

public class User
{
    String userName;
    String userId;
    Map<Product,Integer> productsVsCount;

    public Map<Product, Integer> getProductsVsCount() {
        return productsVsCount;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    Location address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<Product,Integer> getProductCategoryList() {
        return productsVsCount;
    }

    public void setProductsVsCount(Map<Product,Integer> productsVsCount) {
        this.productsVsCount = productsVsCount;
    }

}
