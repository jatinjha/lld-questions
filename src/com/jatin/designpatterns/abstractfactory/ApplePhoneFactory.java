package com.jatin.designpatterns.abstractfactory;

public class ApplePhoneFactory {
    public static Phone getApplePhone(String modelName){
        switch (modelName){
            case "Iphone14" : return new Iphone14();
            default: return null;
        }
    }
}
