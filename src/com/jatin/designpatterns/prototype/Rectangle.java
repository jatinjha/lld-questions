package com.jatin.designpatterns.prototype;

public class Rectangle implements ShapePrototype {

    int length;
    int breadth;

    public Rectangle(int length , int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    public ShapePrototype clone() {
        return new Rectangle(this.length,this.breadth);
    }
}
