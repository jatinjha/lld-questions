package com.jatin.carrental.models;

public class CODPaymentMode implements PaymentMode{
    @Override
    public void payBill() {
        System.out.println("payment by cod mode");
    }
}
