package com.jatin.elevatorsystem;

import com.jatin.elevatorsystem.enums.ELEVATOR_STATUS;
import com.jatin.elevatorsystem.model.ElevatorCar;
import com.jatin.elevatorsystem.model.ExternalButton;
import com.jatin.elevatorsystem.model.InternalButton;
import com.jatin.elevatorsystem.service.ElevatorControllerService;
import com.jatin.elevatorsystem.service.ElevatorCreator;
import com.jatin.elevatorsystem.service.ExternalButtonDispatcher;
import com.jatin.elevatorsystem.strategy.AllDispatcherValidatorStrategy;

import java.util.List;

public class ElevatorDriverClass {
    public static void main(String[] args) {
        System.out.println("start elevator program");
        ElevatorCar elevatorCarOne = ElevatorCreator.elevatorCars.get(0);
        elevatorCarOne.setElevatorStatus(ELEVATOR_STATUS.IDLE);

        ExternalButton externalButton = new ExternalButton();
        externalButton.pressButton(elevatorCarOne,2);
        externalButton.pressButton(elevatorCarOne,6);
//        InternalButton internalButton = new InternalButton();
//        internalButton.submitRequest(elevatorCarOne,3);
        externalButton.pressButton(elevatorCarOne,1);

        System.out.println("end elevator program");
    }
}
