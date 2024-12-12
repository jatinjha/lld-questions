package com.jatin.vendingmachine;

public class Item {
    private String name;
    private double price;
    private String itemId;
    private int itemCount;

    public Item(String name, double price, String itemId, int itemCount) {
        this.name = name;
        this.price = price;
        this.itemId = itemId;
        this.itemCount = itemCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
