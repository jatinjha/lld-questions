package com.jatin.vendingmachine.states;

import com.jatin.vendingmachine.Item;
import com.jatin.vendingmachine.VendingMachine;
import com.jatin.vendingmachine.enums.Coin;

import java.util.List;

public interface State {
    public void insertCoin(VendingMachine vendingMachine,List<Coin> coins) throws Exception;
    public void selectProduct(VendingMachine vendingMachine, int itemId) throws Exception;
    public void getChange(double change) throws Exception;
    public Item dispenseProduct(VendingMachine vendingMachine , int itemId) throws Exception;
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception;
}
