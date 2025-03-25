package com.jatin.designpatterns.abstractfactory;

public class PhoneFactory {
    public static Phone getPhone(String companyName , String modelName){
        if(companyName.equals("Apple")){
            return ApplePhoneFactory.getApplePhone(modelName);
        }
        else{
            return SamsungPhoneFactory.getSamsungPhone(modelName);
        }
    }
}
