package com.jatin.designpatterns.statedesingpatterns;

public class PublishState implements DocumentState{

    @Override
    public void publish(Document document) {
        System.out.println("document in publish state");

    }
}
