package com.jatin.designpatterns.prototype;

public class Circle implements ShapePrototype {

    private int radius;
    private String colour;

    public Circle(int radius , String colour){
        this.radius = radius;
        this.colour = colour;
    }
    @Override
    public ShapePrototype clone() {
        return new Circle(this.radius,this.colour);
    }

    public String toString(){
        return " "+"color ->"+this.colour;
    }
}
