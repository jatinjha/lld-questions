package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

public class DebugLogger extends LoggerAbstract{

    public DebugLogger(LogLevel logLevel){
        this.logLevel = logLevel;
    }
    public void display(String message , LogSubject logSubject) {
        logSubject.notifyAllObserver(logLevel,message);
    }
}
