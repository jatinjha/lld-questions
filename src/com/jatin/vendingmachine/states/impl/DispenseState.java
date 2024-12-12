package com.jatin.vendingmachine.states.impl;

import com.jatin.vendingmachine.Item;
import com.jatin.vendingmachine.VendingMachine;
import com.jatin.vendingmachine.enums.Coin;
import com.jatin.vendingmachine.states.State;

import java.util.List;
import java.util.Map;

public class DispenseState implements State {

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) throws Exception {
        throw new Exception("can't insert in dispense state");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        throw new Exception("can't select product in dispsense state");
    }

    @Override
    public void getChange(double change) throws Exception {
        throw new Exception("can't provide change in dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemId) throws Exception {
        Item item = vendingMachine.getInventory().get(itemId);
        System.out.println("dispense Item :- "+item);
        Map<Integer,Item> vendingMachineInventory = vendingMachine.getInventory();
        item.setItemCount(item.getItemCount()-1);
        vendingMachineInventory.put(itemId,item);
        vendingMachine.setVendingMachineState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can't refund money in dispense state");
    }
}
