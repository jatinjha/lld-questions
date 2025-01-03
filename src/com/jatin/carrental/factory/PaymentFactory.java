package com.jatin.carrental.factory;

import com.jatin.carrental.models.CCPaymentMode;
import com.jatin.carrental.models.CODPaymentMode;
import com.jatin.carrental.models.PaymentMode;

public class PaymentFactory {
    public static PaymentMode getPaymentMode(String name){
        switch (name){
            case "COD" : return new CODPaymentMode();
            default: return new CCPaymentMode();
        }
    }
}
