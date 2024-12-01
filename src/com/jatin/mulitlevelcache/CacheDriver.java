package com.jatin.mulitlevelcache;

import com.jatin.mulitlevelcache.exception.InvalidCacheSize;
import com.jatin.mulitlevelcache.exception.InvalidKey;

public class CacheDriver {



    public static void main(String[] args)  {
        try{
            DataStorage<String,String> dataStorage = new InMeomoryDataStorage<>();
            KeyEvictionPolicy<String> keyEvictionPolicy = new LRUEvictionPolicy<>();
            CacheStorage<String,String> cacheStorage = new CacheStorage<>(dataStorage,keyEvictionPolicy,4);
            cacheStorage.put("A","12aaa22");
            cacheStorage.put("B","1bbbbb122");
            cacheStorage.put("C","1cccc122");
            System.out.println("value of A "+cacheStorage.get("A"));
            System.out.println("value of C "+cacheStorage.get("C"));
            cacheStorage.put("D","1dddd122");
            cacheStorage.put("E","eeeee2");
            cacheStorage.put("C","12323cccc");
            System.out.println("value of C "+cacheStorage.get("C"));
            System.out.println("value of E "+cacheStorage.get("E"));
            System.out.println("value of B "+cacheStorage.get("B"));

        }catch (Exception ex){
            System.out.println("got following exception "+ex.getMessage());
        }


    }
}
