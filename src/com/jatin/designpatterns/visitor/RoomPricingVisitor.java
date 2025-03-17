package com.jatin.designpatterns.visitor;

public class RoomPricingVisitor implements RoomVisitor{
    @Override
    public void visit(NormalRoom normalRoom) {
        normalRoom.roomPrice = 1000;

    }

    @Override
    public void visit(DeluxRoom deluxRoom) {
        deluxRoom.roomPrice = 3000;
    }
}
