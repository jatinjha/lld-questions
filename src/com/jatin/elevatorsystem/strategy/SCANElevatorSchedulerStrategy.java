package com.jatin.elevatorsystem.strategy;

import com.jatin.elevatorsystem.enums.DIRECTION;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SCANElevatorSchedulerStrategy implements ElevatorSchedulerStrategy{
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    int currentFloor;
    List<Integer> floorRequests = new ArrayList<>();

    @Override
    public void setCurrentFloor(int currentFloor){
        this.currentFloor = currentFloor;
    }

    @Override
    public void submitRequest(int floor, DIRECTION elevatorDirection) {
            floorRequests.add(floor);
            while(!(minHeap.isEmpty()||maxHeap.isEmpty())) {
                if (elevatorDirection.equals(DIRECTION.UP)) {
                    if(!minHeap.isEmpty())
                        System.out.println("served request for floor : "+minHeap.poll());

                    if (floor - this.currentFloor > 0)
                        minHeap.add(floor);
                    else
                        maxHeap.add(floor);
                } else {
                    if(!maxHeap.isEmpty())
                        System.out.println("served request for floor : "+maxHeap.poll());

                    if (floor - this.currentFloor > 0) {
                        maxHeap.add(floor);
                    } else {
                        minHeap.add(floor);
                    }
                }
            }
            if(minHeap.isEmpty()&&maxHeap.isEmpty()){
                if(elevatorDirection.equals(DIRECTION.UP)){
                    System.out.println("direction is up and minHeap is emty");
                    minHeap.add(floor);
                }
                else{
                    System.out.println("direction is down and maxHeap is emty");
                    maxHeap.add(floor);
                }
            }
    }

    public int getNextFloor(DIRECTION direction){
        if(direction.equals(DIRECTION.UP) && !minHeap.isEmpty()){
            return minHeap.peek();
        }
        if(direction.equals(DIRECTION.DOWN) && !maxHeap.isEmpty()){
            return maxHeap.peek();
        }
        return -1;
    }

}
