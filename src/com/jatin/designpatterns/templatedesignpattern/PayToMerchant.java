package com.jatin.designpatterns.templatedesignpattern;

public class PayToMerchant extends PaymentFlow{

    @Override
    public void validateRequest() {
        System.out.println("validation for merchant sent to bank");
    }

    @Override
    public void calculateFees() {
        System.out.println("2% platform deducted");
    }

    @Override
    public void debitAmount() {
        System.out.println("transaction amount debited");
    }

    @Override
    public void creditAmount() {
        System.out.println("original transaction - 2% platform fee");
    }
}
