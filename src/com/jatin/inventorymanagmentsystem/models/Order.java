package com.jatin.inventorymanagmentsystem.models;

import com.jatin.carrental.models.Location;
import com.jatin.inventorymanagmentsystem.enums.OrderStatus;
import com.jatin.inventorymanagmentsystem.services.InventoryService;
import com.jatin.inventorymanagmentsystem.services.strategy.PaymentMode;
import com.jatin.inventorymanagmentsystem.services.strategy.UPIPaymentMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    String orderId;
    Map<Product,Integer> productsVsCount;
    User user;
    Location deliveryAddress;
    Payment payment;
    OrderStatus orderStatus;
    Invoice invoice;

    public Order(User user, WareHouse warehouse){
        this.user = user;
        this.productsVsCount = user.getProductCategoryList();
        this.deliveryAddress = user.getAddress();
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout(){

        for(Product product : productsVsCount.keySet()){
            WareHouse wareHouse = product.getWareHouse();
            InventoryService inventoryService = wareHouse.getInventoryService();
            inventoryService.removeProduct(product.productCategory,product);
        }

        //2. make Payment

        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        //3. make cart empty
        if(isPaymentSuccess) {
            user.setProductsVsCount(new HashMap<>());
        }
        else{
            for(Product product : productsVsCount.keySet()){
                WareHouse wareHouse = product.getWareHouse();
                InventoryService inventoryService = wareHouse.getInventoryService();
                inventoryService.addProduct(product.productCategory,product);
            }
        }

    }

    public boolean makePayment(PaymentMode paymentMode){
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }

}
