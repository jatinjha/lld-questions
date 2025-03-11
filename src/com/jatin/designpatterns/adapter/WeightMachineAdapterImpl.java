package com.jatin.designpatterns.adapter;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public int getWeightInKilos() {
        return (int) (weightMachine.getWeightInPound()*4.5);
    }
}
