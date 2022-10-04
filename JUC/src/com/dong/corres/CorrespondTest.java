package com.dong.corres;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MeidongXia
 * @date 2022/2/17 16:02
 */
public class CorrespondTest {
    public static void main(String[] args) {

        Variant variant = new Variant();
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

class Variant{
    private int num = 0;



    public synchronized void add(){
            while(num==1){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.num++;
            System.out.println(Thread.currentThread().getName()+" 当前值： "+this.num);
            this.notifyAll();
    }

    public synchronized void subtract(){

            while(num==0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.num--;
            System.out.println(Thread.currentThread().getName()+" 当前值： "+this.num);
            this.notifyAll();

    }

}
