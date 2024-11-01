package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

public class LogManager {
    public static LoggerAbstract handleChaining(){
        LoggerAbstract infoLogger = new InfoLogger(LogLevel.INFO);
        LoggerAbstract debugLogger = new DebugLogger(LogLevel.DEBUG);
        LoggerAbstract errorLogger = new ErrorLogger(LogLevel.ERROR);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        return infoLogger;
    }
    public static LogSubject getLogSubject(){
        LogSubject logSubject = new LogSubjectImplementation();
        logSubject.addObserver(LogLevel.INFO,new ConsoleLogger());
        logSubject.addObserver(LogLevel.DEBUG,new ConsoleLogger());
        logSubject.addObserver(LogLevel.ERROR,new ConsoleLogger());
        logSubject.addObserver(LogLevel.ERROR,new FileLogger());
        return logSubject;
    }
}
