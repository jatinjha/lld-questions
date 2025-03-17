package com.jatin.designpatterns.visitor;

public class NormalRoom implements RoomElement{
    int roomPrice = 0;
    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }

}
