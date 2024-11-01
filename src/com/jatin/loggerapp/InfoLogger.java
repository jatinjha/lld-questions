package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

public class InfoLogger extends LoggerAbstract {

    public InfoLogger(LogLevel logLevel){
        this.logLevel = logLevel;
    }
    @Override
    public void display(String message,LogSubject logSubject) {
        logSubject.notifyAllObserver(logLevel,message);
    }
}
