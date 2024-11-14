package com.jatin.designpatterns.observerdesignpattern.subject;

import com.jatin.designpatterns.observerdesignpattern.observer.StockPriceUpdateObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockMarketSubjectImplementation implements StockMarketSubject{

    private List<StockPriceUpdateObserver> stockObserver = new ArrayList<>();
    private Map<String,Double> stockSymbolVsPrice = new HashMap<>();

    @Override
    public void registerObserver(StockPriceUpdateObserver stockPriceUpdateObserver) {
        stockObserver.add(stockPriceUpdateObserver);
    }

    @Override
    public void removeObserver(StockPriceUpdateObserver stockPriceUpdateObserver) {
        stockObserver.remove(stockPriceUpdateObserver);
    }

    @Override
    public void notifyAllObservers() {
        for(StockPriceUpdateObserver stockPriceUpdateObserver : stockObserver){
            stockPriceUpdateObserver.update();
        }
    }

    @Override
    public void setData(String stockSymbol, double stockPrice) {
        stockSymbolVsPrice.put(stockSymbol,stockPrice);
        if(!stockObserver.isEmpty())
            notifyAllObservers();
    }

    @Override
    public Map<String,Double> getData() {
        return stockSymbolVsPrice;
    }
}
