package com.jatin.elevatorsystem.service;

import com.jatin.elevatorsystem.enums.DIRECTION;
import com.jatin.elevatorsystem.model.ElevatorCar;
import com.jatin.elevatorsystem.strategy.DispatcherValidatorStrategy;

import java.util.List;
import java.util.Optional;

public class InternalButtonDispatcher {

    List<ElevatorControllerService> elevatorControllerServiceList = ElevatorCreator.elevatorControllerServiceList;
    DispatcherValidatorStrategy dispatcherValidatorStrategy;

    public InternalButtonDispatcher(DispatcherValidatorStrategy dispatcherValidatorStrategy){
        this.dispatcherValidatorStrategy = dispatcherValidatorStrategy;
    }

    public void submitRequest(String elevatorId , DIRECTION direction , int floor){
        if(dispatcherValidatorStrategy.checkDestinationValidity(elevatorId,"*",String.valueOf(floor))){
            Optional<ElevatorControllerService> elevatorControllerService = elevatorControllerServiceList.stream().filter(elevatorControllerServiceObj -> elevatorControllerServiceObj.getElevatorCar().getElevatorId().equals(elevatorId)).findFirst();
            elevatorControllerService.ifPresent(controllerService -> controllerService.submitRequest(floor));
        }
    }
}
