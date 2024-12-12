package com.jatin.vendingmachine.states.impl;

import com.jatin.vendingmachine.Item;
import com.jatin.vendingmachine.VendingMachine;
import com.jatin.vendingmachine.enums.Coin;
import com.jatin.vendingmachine.states.State;

import java.util.List;

public class SelectionState implements State {


    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) throws Exception {
        throw new Exception("can't insert coins in selection state");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        Item item = vendingMachine.getInventory().get(itemId);

        if(item.getItemCount()<=0){
            throw new Exception("Item is not available");
        }

        List<Coin> coins = vendingMachine.getCoinList();
        double providedAmt = coins.stream().mapToInt(value -> value.value).sum();

        if(providedAmt < item.getPrice()){
            System.out.println("short in funds");
            refundMoney(vendingMachine);
            throw new Exception("short in funds");
        }
        if(providedAmt > item.getPrice()){
            getChange(providedAmt-item.getPrice());
        }
        vendingMachine.setVendingMachineState(new DispenseState());
    }

    @Override
    public void getChange(double change) throws Exception {
        throw new Exception("return change value "+change);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        throw new Exception("can't dispense in selection state");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }
}
