package com.jatin.elevatorsystem.service;

import com.jatin.elevatorsystem.enums.ELEVATOR_STATUS;
import com.jatin.elevatorsystem.model.ElevatorCar;
import com.jatin.elevatorsystem.strategy.SCANElevatorSchedulerStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ElevatorCreator {
    public static List<ElevatorControllerService> elevatorControllerServiceList = new ArrayList<>();
    public static List<ElevatorCar> elevatorCars = new ArrayList<>();
    static {
        ElevatorCar elevatorCarOne = new ElevatorCar(UUID.randomUUID().toString());
        ElevatorControllerService elevatorControllerServiceOne = new ElevatorControllerService(elevatorCarOne,new SCANElevatorSchedulerStrategy());
        elevatorCars.add(elevatorCarOne);
        elevatorCarOne.setElevatorStatus(ELEVATOR_STATUS.IDLE);
        ElevatorCar elevatorCarTwo = new ElevatorCar(UUID.randomUUID().toString());
        ElevatorControllerService elevatorControllerServiceTwo = new ElevatorControllerService(elevatorCarTwo,new SCANElevatorSchedulerStrategy());
        elevatorCars.add(elevatorCarTwo);
        elevatorCarTwo.setElevatorStatus(ELEVATOR_STATUS.IDLE);
        elevatorControllerServiceList.add(elevatorControllerServiceOne);
        elevatorControllerServiceList.add(elevatorControllerServiceTwo);
    }
}
