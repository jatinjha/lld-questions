package com.jatin.elevatorsystem.service;

import com.jatin.elevatorsystem.enums.DIRECTION;
import com.jatin.elevatorsystem.model.ElevatorCar;
import com.jatin.elevatorsystem.strategy.DispatcherValidatorStrategy;

import java.util.List;
import java.util.Optional;

public class ExternalButtonDispatcher {
    private final List<ElevatorControllerService> elevatorControllerServiceList = ElevatorCreator.elevatorControllerServiceList;
    private final DispatcherValidatorStrategy dispatcherValidatorStrategy;

    public ExternalButtonDispatcher(DispatcherValidatorStrategy dispatcherValidatorStrategy){
        this.dispatcherValidatorStrategy = dispatcherValidatorStrategy;
    }

    public void submitRequest(ElevatorCar elevatorCar , int floor){
        // put logic like even-odd , range  wise elevators

        for(ElevatorControllerService elevatorControllerService : elevatorControllerServiceList){
            if(dispatcherValidatorStrategy.checkDestinationValidity(elevatorControllerService.getElevatorCar().getElevatorId(),"*",String.valueOf(floor))){
               Optional<ElevatorControllerService> elevatorControllerServiceRequestObj = elevatorControllerServiceList.stream().filter(obj -> obj.getElevatorCar().getElevatorId().equals(elevatorCar.getElevatorId())).findFirst();
                elevatorControllerServiceRequestObj.ifPresent(controllerService -> controllerService.submitRequest(floor));
            }
        }
    }
}
