package com.jatin.designpatterns.visitor;

public class RoomMaintainceVisitor implements RoomVisitor{
    @Override
    public void visit(NormalRoom normalRoom) {
        System.out.println("normal room maintence");
    }

    @Override
    public void visit(DeluxRoom deluxRoom) {
        System.out.println("deluxRoom room maintence");
    }
}
