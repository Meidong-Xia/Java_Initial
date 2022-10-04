package com.dong.lock;

/**
 * @author MeidongXia
 * @date 2022/2/19 14:32
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println("获得o，期望获得o2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("获得o2");
                }
            }
        },"aa").start();

        new Thread(()->{
            synchronized (o2){
                System.out.println("获得o2，期望获得o");
                synchronized (o) {
                    System.out.println("获得o");
                }
            }
        },"bb").start();
    }

}
