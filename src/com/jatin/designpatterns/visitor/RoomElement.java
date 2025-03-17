package com.jatin.designpatterns.visitor;

public interface RoomElement {
    public void accept(RoomVisitor roomVisitor);
}
