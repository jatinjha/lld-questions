package com.jatin.designpatterns.statedesingpatterns;

public class StateDriverClass {

    public static void main(String[] args) {
        Document document = new Document();
        DocumentState documentState = new DraftState();
        document.setState(documentState);
        System.out.println("document state -> "+document.getState());
        documentState.publish(document);

        System.out.println("document state -> "+document.getState());
        document.getState().publish(document);
        System.out.println("document state"+document.getState());
    }
}
