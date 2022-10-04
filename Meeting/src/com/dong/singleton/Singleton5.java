package com.dong.singleton;

/**
 * @author MeidongXia
 * @date 2022/3/8 10:13
 * 内部类并不会在外部类加载和初始化的时候进行加载和初始话
 */
public class Singleton5 {
    private Singleton5(){

    }
    private static class Inn{
        private  static final Singleton5 INSTANCE = new Singleton5();
    }
    public static Singleton5 getInstance(){
        return Inn.INSTANCE;
    }
}
