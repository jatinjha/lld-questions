package com.jatin.designpatterns.singleton;

import java.util.Objects;

public class DataBaseInstance {
    private static volatile DataBaseInstance dataBaseInstance;

    /*
        We can do class level lock on here but as
        we want to minimize the risk of contention with other synchronization logic in the class or application.
        we will use mutex
     */
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
