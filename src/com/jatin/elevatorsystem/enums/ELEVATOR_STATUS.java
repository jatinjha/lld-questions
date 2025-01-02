package com.jatin.elevatorsystem.enums;

public enum ELEVATOR_STATUS {
    IDLE("idle"),
    MOVING("moving");
    private final String value;
    ELEVATOR_STATUS(String value){
        this.value = value;
    }
}
