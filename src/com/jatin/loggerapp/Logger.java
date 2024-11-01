package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

import java.util.Objects;

public class Logger {
    public static Logger logger;
    public static Object mutex = new Object();
    public static LoggerAbstract loggerAbstract;
    public static LogSubject logSubject;

    private Logger(){
        if(Objects.nonNull(logger)){
            System.out.print("invalid operation object is present already");
        }
    }

    public static Logger getInstance(){
        Logger loggerInstance = logger;
        if(Objects.isNull(loggerInstance)){
            synchronized (mutex){
                loggerInstance = logger;
                if(Objects.isNull(loggerInstance)){
                    logger = loggerInstance = new Logger();
                    loggerAbstract = LogManager.handleChaining();
                    logSubject = LogManager.getLogSubject();
                }
            }
            return loggerInstance;
        }
        return logger;
    }

    public void log(LogLevel logLevel , String message){
        loggerAbstract.logMessage(logLevel,message,logSubject);
    }
}
