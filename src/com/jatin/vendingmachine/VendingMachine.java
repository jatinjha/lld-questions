package com.jatin.vendingmachine;

import com.jatin.vendingmachine.enums.Coin;
import com.jatin.vendingmachine.states.State;
import com.jatin.vendingmachine.states.impl.IdleState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Map<Integer,Item> inventory;
    private State vendingMachineState;
    private List<Coin> coinList;

    public VendingMachine(){
        inventory = new HashMap<>();
        coinList = new ArrayList<>();
        vendingMachineState = new IdleState();
    }

    public Map<Integer, Item> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Integer, Item> inventory) {
        this.inventory = inventory;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
