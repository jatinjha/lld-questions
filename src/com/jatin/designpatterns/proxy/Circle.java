package com.jatin.designpatterns.proxy;

public class Circle implements ShapeProxy{

    private int radius;
    private String colour;

    public Circle(int radius , String colour){
        this.radius = radius;
        this.colour = colour;
    }
    @Override
    public ShapeProxy clone() {
        return new Circle(this.radius,this.colour);
    }

    public String toString(){
        return " "+"color ->"+this.colour;
    }
}
