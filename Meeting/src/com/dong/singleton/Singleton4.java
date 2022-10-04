package com.dong.singleton;

/**
 * @author MeidongXia
 * @date 2022/3/8 10:04
 */
public class Singleton4 {
    private static volatile Singleton4 INSTANCE = null;
    private Singleton4(){

    }
    public static Singleton4 getInstance(){
        if(INSTANCE == null){
            synchronized(INSTANCE){
                if(INSTANCE==null){
                    INSTANCE =  new Singleton4();
                }
            }
        }
        return INSTANCE;
    }
}
