package com.jatin.designpatterns.statedesingpatterns;

public class ModificationState implements DocumentState{

    @Override
    public void publish(Document document) {
        //System.out.println("document in modification state");
        document.setState(new PublishState());
    }
}
