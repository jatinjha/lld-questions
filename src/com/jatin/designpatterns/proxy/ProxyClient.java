package com.jatin.designpatterns.proxy;

public class ProxyClient {
    public static void main(String[] args) {
        Circle circle = new Circle(4,"r");
        Circle circleClone = (Circle) circle.clone();
        System.out.println(circleClone.toString());
    }
}
