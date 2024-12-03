package com.jatin.designpatterns.templatedesignpattern;

public class PayToFriend extends PaymentFlow{

    @Override
    public void validateRequest() {
        System.out.println("validation sent to npci");
    }

    @Override
    public void calculateFees() {
        System.out.println("zero charges for this mode");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit request sent");
    }

    @Override
    public void creditAmount() {
        System.out.println("credit request sent");
    }
}
