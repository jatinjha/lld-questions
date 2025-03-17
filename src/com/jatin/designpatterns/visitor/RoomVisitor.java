package com.jatin.designpatterns.visitor;

public interface RoomVisitor {
    public void visit(NormalRoom normalRoom);
    public void visit(DeluxRoom deluxRoom);
}
