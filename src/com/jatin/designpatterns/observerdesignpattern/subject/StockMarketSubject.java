package com.jatin.designpatterns.observerdesignpattern.subject;

import com.jatin.designpatterns.observerdesignpattern.observer.StockPriceUpdateObserver;

import java.util.Map;

public interface StockMarketSubject {

    public void registerObserver(StockPriceUpdateObserver stockPriceUpdateObserver);
    public void removeObserver(StockPriceUpdateObserver stockPriceUpdateObserver);
    public void notifyAllObservers();
    public void setData(String stockSymbol , double stockPrice);
    public Map<String,Double> getData();

}
