package com.jatin.designpatterns.adapter;

public class AdapterDriver {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineImpl());
        System.out.println(weightMachineAdapter.getWeightInKilos());
    }
}
