package com.jatin.designpatterns.singleton;

public class SingletonDriver {
    public static void main(String[] args) {
        DataBaseInstance dataBaseInstance = DataBaseInstance.getDataBaseInstance();
        System.out.println(dataBaseInstance);
    }
}
