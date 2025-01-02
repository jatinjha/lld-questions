package com.jatin.elevatorsystem.model;

import com.jatin.elevatorsystem.enums.DIRECTION;
import com.jatin.elevatorsystem.enums.ELEVATOR_STATUS;

public class ElevatorCar {
    String elevatorId;
    Display display;
    int floor;
    DIRECTION direction;
    InternalButton internalButton;
    ELEVATOR_STATUS elevatorStatus;

    public ElevatorCar(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    public void moveToFloor(DIRECTION direction , int destFloor){
        this.elevatorStatus = ELEVATOR_STATUS.MOVING;
        this.direction = direction;

    }


    public String getElevatorId() {
        return elevatorId;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public void setInternalButton(InternalButton internalButton) {
        this.internalButton = internalButton;
    }

    public ELEVATOR_STATUS getElevatorStatus() {
        return elevatorStatus;
    }

    public void setElevatorStatus(ELEVATOR_STATUS elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }
}
