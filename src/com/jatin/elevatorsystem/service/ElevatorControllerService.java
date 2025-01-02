package com.jatin.elevatorsystem.service;

import com.jatin.elevatorsystem.enums.DIRECTION;
import com.jatin.elevatorsystem.enums.ELEVATOR_STATUS;
import com.jatin.elevatorsystem.model.ElevatorCar;
import com.jatin.elevatorsystem.strategy.ElevatorSchedulerStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorControllerService {
    private ElevatorCar elevatorCar;
    private ElevatorSchedulerStrategy elevatorSchedulerStrategy;
    private ArrayList<Integer> requests = new ArrayList<>();

    public ElevatorControllerService(ElevatorCar elevatorCar , ElevatorSchedulerStrategy elevatorSchedulerStrategy){
        this.elevatorCar = elevatorCar;
        this.elevatorSchedulerStrategy = elevatorSchedulerStrategy;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void submitRequest(int floor)
    {
        System.out.println("elevator status : "+elevatorCar.getElevatorStatus());
        System.out.println("request recived for floor : "+floor);
        System.out.println("current floor on which elevator car is : "+elevatorCar.getFloor());
        requests.add(floor);
        if(elevatorCar.getElevatorStatus().equals(ELEVATOR_STATUS.IDLE)){
            if(floor-elevatorCar.getFloor()>0){
                elevatorSchedulerStrategy.setCurrentFloor(elevatorCar.getFloor());
                elevatorCar.setDirection(DIRECTION.UP);
                elevatorCar.setElevatorStatus(ELEVATOR_STATUS.MOVING);
                elevatorSchedulerStrategy.submitRequest(floor,DIRECTION.UP);

            }
            else{
                elevatorSchedulerStrategy.setCurrentFloor(elevatorCar.getFloor());
                elevatorCar.setDirection(DIRECTION.DOWN);
                elevatorCar.setElevatorStatus(ELEVATOR_STATUS.MOVING);
                elevatorSchedulerStrategy.submitRequest(floor,DIRECTION.DOWN);
            }
        }
        else{
            DIRECTION currentDirection = elevatorCar.getDirection();
            int nextFloor = elevatorSchedulerStrategy.getNextFloor(currentDirection);
            if(nextFloor == elevatorCar.getFloor()){
                currentDirection = elevatorCar.getDirection().equals(DIRECTION.UP)?DIRECTION.DOWN:DIRECTION.UP;
            }

            System.out.println("next floor : "+elevatorSchedulerStrategy.getNextFloor(currentDirection));
            elevatorCar.setFloor(elevatorSchedulerStrategy.getNextFloor(currentDirection));
            elevatorCar.setElevatorStatus(ELEVATOR_STATUS.MOVING);
            elevatorSchedulerStrategy.submitRequest(floor,currentDirection);

        }
    }
}
