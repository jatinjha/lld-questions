package com.jatin.designpatterns.abstractfactory;

public class SamsungPhoneFactory {
    public static Phone getSamsungPhone(String modelName){
        if(modelName.equals("zfold")){
            return new SamsungFold();
        }
        return null;
    }
}
