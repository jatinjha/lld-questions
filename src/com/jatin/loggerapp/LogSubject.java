package com.jatin.loggerapp;

import com.jatin.loggerapp.enums.LogLevel;

public interface LogSubject {
    public void addObserver(LogLevel logLevel , LogObserver logObserver);
    public void removeObserver(LogObserver logObserver);
    public void notifyAllObserver(LogLevel logLevel , String message);
}
