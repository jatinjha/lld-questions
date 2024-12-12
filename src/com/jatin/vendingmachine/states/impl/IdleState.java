package com.jatin.vendingmachine.states.impl;

import com.jatin.vendingmachine.Item;
import com.jatin.vendingmachine.VendingMachine;
import com.jatin.vendingmachine.enums.Coin;
import com.jatin.vendingmachine.states.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(){
        System.out.println("currently machine in idle state");
    }


    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) throws Exception {
        vendingMachine.setCoinList(new ArrayList<>());
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        throw new Exception("can't select a product in idle state");
    }

    @Override
    public void getChange(double change) throws Exception {
        throw new Exception("can't give change idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        throw new Exception("can't dispense a product in idle state");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can't refund in idle state");
    }
}
