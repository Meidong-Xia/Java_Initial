package com.dong.singleton;

/**
 * @author MeidongXia
 * @date 2022/3/8 9:59
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    static{
        INSTANCE = new Singleton3();
    }
    private Singleton3(){

    }

}
