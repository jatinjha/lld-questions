package com.jatin.elevatorsystem.model;

import com.jatin.elevatorsystem.service.ElevatorControllerService;
import com.jatin.elevatorsystem.service.ElevatorCreator;
import com.jatin.elevatorsystem.service.ExternalButtonDispatcher;
import com.jatin.elevatorsystem.strategy.AllDispatcherValidatorStrategy;

import java.util.List;
import java.util.Optional;

public class ExternalButton {
    private ExternalButtonDispatcher externalButtonDispatcher;


    public ExternalButton(){
        externalButtonDispatcher = new ExternalButtonDispatcher(new AllDispatcherValidatorStrategy());
    }

    public void pressButton(ElevatorCar elevatorCar, int floor){
        System.out.println("presed external button for elevator "+elevatorCar.getElevatorId());
        System.out.println("requested elevator "+elevatorCar.getElevatorId());
        externalButtonDispatcher.submitRequest(elevatorCar , floor);
    }

}
