package com.dong.corres;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MeidongXia
 * @date 2022/2/17 16:59
 */
public class LCorrespondTest {
    public static void main(String[] args) {
        Variant2 variant = new Variant2();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                variant.add();
            }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                variant.subtract();
            }
        },"bb").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                variant.add();
            }
        },"cc").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                variant.subtract();
            }
        },"dd").start();

    }
}

class Variant2{
    private int num = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add(){
        lock.lock();
        try{
            while(num==1){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.num++;
            System.out.println(Thread.currentThread().getName()+" 当前值： "+this.num);
            condition.signalAll();
        }finally{
            lock.unlock();
        }

    }

    public void subtract(){

        new HashSet();
        lock.lock();
        try{
            while(num==0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.num--;
            System.out.println(Thread.currentThread().getName()+" 当前值： "+this.num);
            condition.signalAll();
        }finally{
            lock.unlock();
        }


    }

}

