package com.jatin.designpatterns.templatedesignpattern;

public class TemplateDesignPatternDriverClass {
    public static void main(String[] args) {
        PaymentFlow paymentFlowFriend = new PayToFriend();
        PaymentFlow paymentFlowMerchant = new PayToMerchant();

        paymentFlowFriend.sendMoney();

        System.out.println("================= ");

        paymentFlowMerchant.sendMoney();
    }
}
