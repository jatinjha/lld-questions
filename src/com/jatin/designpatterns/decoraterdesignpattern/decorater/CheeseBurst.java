package com.jatin.designpatterns.decoraterdesignpattern.decorater;

import com.jatin.designpatterns.decoraterdesignpattern.BasePizza;

public class CheeseBurst extends ToppingDecorator{
    BasePizza basePizza;

    public CheeseBurst(BasePizza basePizza){
        this.basePizza = basePizza;
    }


    @Override
    public double cost() {
        return basePizza.cost()+125;
    }
}
