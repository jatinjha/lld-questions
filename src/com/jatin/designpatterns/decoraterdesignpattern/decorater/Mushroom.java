package com.jatin.designpatterns.decoraterdesignpattern.decorater;

import com.jatin.designpatterns.decoraterdesignpattern.BasePizza;

public class Mushroom extends ToppingDecorator{

    BasePizza basePizza;

    public Mushroom(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public double cost() {
        return basePizza.cost()+100;
    }
}
