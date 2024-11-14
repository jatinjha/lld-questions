package com.jatin.designpatterns.observerdesignpattern;

import com.jatin.designpatterns.observerdesignpattern.observer.RetailInvestorsImpl;
import com.jatin.designpatterns.observerdesignpattern.observer.StockPriceUpdateObserver;
import com.jatin.designpatterns.observerdesignpattern.subject.StockMarketSubject;
import com.jatin.designpatterns.observerdesignpattern.subject.StockMarketSubjectImplementation;

public class ObserverDesignDriver {
    public static void main(String[] args) {
        StockMarketSubject stockMarketSubjectTCS = new StockMarketSubjectImplementation();
        stockMarketSubjectTCS.setData("TCS",1240);

        StockMarketSubject stockMarketSubjectInfosys = new StockMarketSubjectImplementation();
        stockMarketSubjectInfosys.setData("Infosys",1400);

        StockMarketSubject stockMarketSubjectMRF = new StockMarketSubjectImplementation();
        stockMarketSubjectMRF.setData("MRF",154440);



        StockPriceUpdateObserver stockPriceUpdateObserverJJTCS = new RetailInvestorsImpl("JJ",stockMarketSubjectTCS);
        StockPriceUpdateObserver stockPriceUpdateObserverJJMRF = new RetailInvestorsImpl("JJ",stockMarketSubjectMRF);
        StockPriceUpdateObserver stockPriceUpdateObserverJKInfo = new RetailInvestorsImpl("JK",stockMarketSubjectInfosys);

        stockMarketSubjectTCS.registerObserver(stockPriceUpdateObserverJJTCS);
        stockMarketSubjectInfosys.registerObserver(stockPriceUpdateObserverJKInfo);
        stockMarketSubjectMRF.registerObserver(stockPriceUpdateObserverJJMRF);


        System.out.println("======= after price update =========");

        stockMarketSubjectInfosys.setData("Infosys",12000);
        stockMarketSubjectTCS.setData("TCS",14000);
        stockMarketSubjectMRF.setData("MRF",212000);



        stockMarketSubjectMRF.removeObserver(stockPriceUpdateObserverJJMRF);
        System.out.println("================ post removing ===================");
        stockMarketSubjectInfosys.setData("Infosys",12005);
        stockMarketSubjectTCS.setData("TCS",14008);
        stockMarketSubjectMRF.setData("MRF",212008);


    }
}
