package com.dong.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MeidongXia
 * @date 2022/2/17 15:08
 * 使用Lock进行同步
 */
public class LockTest {
    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//
//            @Override
//            public void run() {
//
//            }
//        };
        LTicket ticket = new LTicket();
        // 创建多个线程
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"aa").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"bb").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"cc").start();
    }


}

// 1. 建立资源类的操作方法
class LTicket{
    private int num = 30;

    // 2. 创建可重入锁
    private final ReentrantLock lock = new  ReentrantLock(); // 默认非公平锁

    public void sale(){
        // 上锁
        lock.lock();
        try{
            if(this.num>0){
                System.out.println(Thread.currentThread().getName()+"卖出 "+(this.num--)+"剩余 "+this.num);
            }
        }finally{
            // 解锁
            lock.unlock();
        }



    }
}






















