package com.jatin.designpatterns.statedesingpatterns;

public class DraftState implements DocumentState{

    @Override
    public void publish(Document document) {
        System.out.println("draft state");
        document.setState(new ModificationState());
    }
}
