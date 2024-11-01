package com.jatin.loggerapp;

public class FileLogger implements LogObserver{
    @Override
    public void update(String message) {
        System.out.println("message printed in file : "+message);
    }
}
