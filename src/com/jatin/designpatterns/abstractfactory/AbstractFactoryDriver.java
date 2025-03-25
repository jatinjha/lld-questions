package com.jatin.designpatterns.abstractfactory;

public class AbstractFactoryDriver {
    public static void main(String[] args) {
        Phone phone = PhoneFactory.getPhone("Apple","Iphone14");
        System.out.println("phone name "+phone.getName());
    }
}
