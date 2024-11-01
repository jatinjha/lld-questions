package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

import java.util.Objects;

public abstract class LoggerAbstract {
    private LoggerAbstract nextLogger;
    protected LogLevel logLevel;

    public void setNextLogger(LoggerAbstract nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogLevel logLevel , String message, LogSubject logSubject){
        if(this.logLevel == logLevel){
            display(message,logSubject);
        }

        if(Objects.nonNull(nextLogger)){
            nextLogger.logMessage(logLevel,message,logSubject);
        }
    }

    public abstract void display(String message , LogSubject logSubject);

}
