package com.jatin.designpatterns.singleton;

import java.util.Objects;

public class DataBaseInstance {
    private static volatile DataBaseInstance dataBaseInstance;
    private static final Object mutex = new Object();
    private DataBaseInstance(){

    }

    public static DataBaseInstance getDataBaseInstance(){
        if(Objects.isNull(dataBaseInstance)){
            synchronized (mutex){
                if (Objects.isNull(dataBaseInstance)){
                    dataBaseInstance = new DataBaseInstance();
                }
            }
        }
        return dataBaseInstance;
    }
}
