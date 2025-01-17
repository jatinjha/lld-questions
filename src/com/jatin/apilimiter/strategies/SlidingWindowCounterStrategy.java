package com.jatin.apilimiter.strategies;

import com.jatin.apilimiter.model.Rule;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowCounterStrategy implements ThrottleStrategy
{
    private final int maxCnt;
    private final long windowLengthMillis;
    private final Clock clock;
    private final Map<String,SlidingWindow> identifierVsSlidingWindow;

    public SlidingWindowCounterStrategy(int maxCnt , long windowLengthMillis , Clock clock){
        this.maxCnt = maxCnt;
        this.windowLengthMillis = windowLengthMillis;
        this.clock = clock;
        identifierVsSlidingWindow = new HashMap<>();
    }

    @Override
    public Boolean isRequestAllowed(String identifier) {
        System.out.println(" current threading checking request is allowed :- "+Thread.currentThread().getName());

        SlidingWindow slidingWindow = identifierVsSlidingWindow.computeIfAbsent(identifier,k->new SlidingWindow(new FixedWindow(clock.millis()
                ,0),new FixedWindow(clock.millis(),0)));

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long now = clock.millis();
        System.out.println(" current value of now :- "+now);

        FixedWindow currentWindow = slidingWindow.currentWindow();
        FixedWindow previousWindow = slidingWindow.previousWindow();

        System.out.println(" current cnt :- "+Thread.currentThread().getName()+" "+currentWindow.count());
        System.out.println(" prevs cnt :- "+Thread.currentThread().getName()+" "+previousWindow.count());

        System.out.println(" current timestamp :- "+currentWindow.timestamp());
        System.out.println(" window length in ms :- "+Thread.currentThread().getName()+" "+windowLengthMillis);

        if(currentWindow.timestamp()+windowLengthMillis<now){
            System.out.println(" current cnt :- "+Thread.currentThread().getName()+"first time sindow creation for user");
            previousWindow = currentWindow;
            currentWindow = new FixedWindow(clock.millis(),0);
            identifierVsSlidingWindow.put(identifier,new SlidingWindow(previousWindow,currentWindow));
        }

        long currentWindowStart = now-windowLengthMillis;
        long previousWindowEnd = previousWindow.timestamp()+windowLengthMillis;

        System.out.println(" current window start :- "+currentWindowStart);
        System.out.println(" previous window end  :- "+previousWindowEnd);


        double previousWindowWeight = Math.max(0,previousWindowEnd-currentWindowStart)/(double)windowLengthMillis;
        int cnt = (int)previousWindowWeight*previousWindow.count()+currentWindow.count();

        System.out.println(" current cnt for current schedule :- "+Thread.currentThread().getName()+" "+cnt);

        if(cnt >= maxCnt){
            return false;
        }

        System.out.println(" request is allowed :- "+Thread.currentThread().getName());

        FixedWindow newCurrentFixedWindow = new FixedWindow(currentWindow.timestamp(), currentWindow.count()+1);
        SlidingWindow newSlidingWindow = new SlidingWindow(previousWindow,newCurrentFixedWindow);
        identifierVsSlidingWindow.put(identifier,newSlidingWindow);
        return true;
    }

    private record SlidingWindow(FixedWindow previousWindow , FixedWindow currentWindow){}
    private record FixedWindow(long timestamp , int count){}
}
