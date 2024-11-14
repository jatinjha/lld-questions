package com.jatin.designpatterns.observerdesignpattern.observer;

import com.jatin.designpatterns.observerdesignpattern.subject.StockMarketSubject;

import java.util.Map;

public class RetailInvestorsImpl implements StockPriceUpdateObserver{

    private String userName;
    private StockMarketSubject stockMarketSubject;
    public RetailInvestorsImpl(String userName , StockMarketSubject stockMarketSubject){
        this.userName = userName;
        this.stockMarketSubject = stockMarketSubject;
    }
    @Override
    public void update() {
        System.out.println("send notification to user :- "+userName);
        this.stockMarketSubject.getData().forEach((k,v)->{
            System.out.println("stock symbol :"+k+"    "+" updated price : "+v);
        });
    }
}
