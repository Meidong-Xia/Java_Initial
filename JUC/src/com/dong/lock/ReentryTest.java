package com.dong.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MeidongXia
 * @date 2022/2/19 11:21
 * 演示可重入锁
 */
public class ReentryTest {
    public static void main(String[] args) {
//        Object o = new Object();
//        new Thread(()->{
//            synchronized (o){
//                System.out.println(Thread.currentThread().getName()+"外层");
//
//                synchronized (o){
//                    System.out.println(Thread.currentThread().getName()+"中层");
//                    synchronized (o){
//                        System.out.println(Thread.currentThread().getName()+"内层");
//                    }
//                }
//            }
//
//        },"t1").start();

        ReentrantLock lock = new ReentrantLock(true);
        new Thread(()->{
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");
                try{
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"内层");
                }finally{
                    lock.unlock(); // 这样会导致该线程一直不释放锁，别的线程一直在等待
                }
            }finally{
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");
                try{
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"内层");
                }finally{
                    lock.unlock();
                }
            }finally{
                lock.unlock();
            }
        },"t2").start();
    }
}
