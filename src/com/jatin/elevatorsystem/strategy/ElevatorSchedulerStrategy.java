package com.jatin.elevatorsystem.strategy;

import com.jatin.elevatorsystem.enums.DIRECTION;

public interface ElevatorSchedulerStrategy {
    public void submitRequest(int floor, DIRECTION elevatorDirection);
    public void setCurrentFloor(int floor);
    public int getNextFloor(DIRECTION elevatorDirection);
}
