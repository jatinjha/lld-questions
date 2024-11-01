package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

public class ApplicationDriver {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        System.out.println("started logging in app");
        logger.log(LogLevel.INFO,"started method");
        logger.log(LogLevel.ERROR,"error method logged");
    }
}
