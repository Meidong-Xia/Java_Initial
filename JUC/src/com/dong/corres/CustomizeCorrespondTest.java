package com.dong.corres;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MeidongXia
 * @date 2022/2/17 17:25
 * 线程间的定制化通信
 */
public class CustomizeCorrespondTest {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                share.print5(i);
            }
        },"aa").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                share.print10(i);
            }
        },"bb").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                share.print15(i);
            }
        },"cc").start();
    }


}

// 创建资源类
class Share{
    private int flag = 1;
    private Lock lock = new ReentrantLock();

    // 创建三个Condition
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(int loop){
        // 上锁
        lock.lock();
        try{
            while(this.flag!=1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+" 当前loop "+loop);
            }
            this.flag = 2;
            c2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public void print10(int loop){
        // 上锁
        lock.lock();
        try{
            while(this.flag!=2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+" 当前loop "+loop);
            }
            this.flag = 3;
            c3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public void print15(int loop){
        // 上锁
        lock.lock();
        try{
            while(this.flag!=3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+" 当前loop "+loop);
            }
            this.flag = 1;
            c1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

}
