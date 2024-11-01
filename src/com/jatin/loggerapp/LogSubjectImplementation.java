package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubjectImplementation implements LogSubject{
    Map<LogLevel , List<LogObserver>> logObserverList = new HashMap<>();

    @Override
    public void addObserver(LogLevel logLevel , LogObserver logObserver) {
        List<LogObserver> observerList = logObserverList.getOrDefault(logLevel,new ArrayList<>());
        observerList.add(logObserver);
        logObserverList.put(logLevel,observerList);
    }

    @Override
    public void removeObserver(LogObserver logObserver) {
        logObserverList.remove(logObserver);
    }

    @Override
    public void notifyAllObserver(LogLevel level , String message) {
        List<LogObserver> observerList = logObserverList.get(level);
        for (LogObserver logObserver : observerList){
            logObserver.update(message);
        }
    }
}
