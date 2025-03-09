package com.jatin.designpatterns.prototype;

public class ProtoTypeClient {
    public static void main(String[] args) {
        Circle circle = new Circle(4,"r");
        Circle circleClone = (Circle) circle.clone();
        System.out.println(circleClone.toString());
    }
}
