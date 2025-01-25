package com.jatin.inventorymanagmentsystem.models;

import com.jatin.inventorymanagmentsystem.services.strategy.PaymentMode;

public class Payment {
    PaymentMode paymentMode;

    public Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean makePayment(){
        return paymentMode.makePayment();
    }
}
