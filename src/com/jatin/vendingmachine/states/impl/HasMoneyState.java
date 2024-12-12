package com.jatin.vendingmachine.states.impl;

import com.jatin.vendingmachine.Item;
import com.jatin.vendingmachine.VendingMachine;
import com.jatin.vendingmachine.enums.Coin;
import com.jatin.vendingmachine.states.State;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState(){
        System.out.println("machine in has money state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) throws Exception {
        List<Coin> vendingMachineCoinList = vendingMachine.getCoinList();
        coins.stream().map(vendingMachineCoinList::add);
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        throw new Exception("can't select product in has money state");
    }

    @Override
    public void getChange(double change) throws Exception {
        throw new Exception("can't give change in has money state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        throw new Exception("can't dispense product in has money state");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can't refund money in has money state");
    }
}
