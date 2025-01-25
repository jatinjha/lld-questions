package com.jatin.inventorymanagmentsystem.services.strategy;

public class UPIPaymentMode implements PaymentMode{

    @Override
    public boolean makePayment() {
        return true;
    }
}

