package com.jatin.designpatterns.chainofresponsbility;

public class ChainOfResponsiblityDriver {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(null));
        logProcessor.log(LogProcessor.ERROR,"error logs ");
        logProcessor.log(LogProcessor.INFO,"info about latency logs ");
        logProcessor.log(LogProcessor.DEBUG," deubgged stacke trace logs ");
    }
}
