package com.jatin.designpatterns.proxy;

public class Rectangle implements ShapeProxy{

    int length;
    int breadth;

    public Rectangle(int length , int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    public ShapeProxy clone() {
        return new Rectangle(this.length,this.breadth);
    }
}
