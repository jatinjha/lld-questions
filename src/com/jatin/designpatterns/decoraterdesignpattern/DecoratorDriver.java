package com.jatin.designpatterns.decoraterdesignpattern;

import com.jatin.designpatterns.decoraterdesignpattern.decorater.CheeseBurst;
import com.jatin.designpatterns.decoraterdesignpattern.decorater.Mushroom;

public class DecoratorDriver {

    public static void main(String[] args) {
        BasePizza basePizza = new Mushroom(new CheeseBurst(new Farmhouse()));
        System.out.println(basePizza.cost());
    }
}
