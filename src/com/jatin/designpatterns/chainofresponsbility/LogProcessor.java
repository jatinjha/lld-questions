package com.jatin.designpatterns.chainofresponsbility;

public abstract class LogProcessor {
    final static int INFO = 1;
    final static int ERROR = 2;
    final static int DEBUG = 3;

    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logLevel , String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(logLevel,message);
        }
    }
}
