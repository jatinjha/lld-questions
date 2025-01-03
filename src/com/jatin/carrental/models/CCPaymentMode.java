package com.jatin.carrental.models;

public class CCPaymentMode implements PaymentMode{
    @Override
    public void payBill() {
        System.out.println("cc payment mode");
    }
}
