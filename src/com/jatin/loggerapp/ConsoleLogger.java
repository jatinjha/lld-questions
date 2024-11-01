package com.jatin.loggerapp;

public class ConsoleLogger implements LogObserver{

    @Override
    public void update(String message) {
        System.out.println("Message printed on console : "+message);
    }
}
