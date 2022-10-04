package com.dong.sync;

/**
 * @author MeidongXia
 * @date 2022/2/17 14:08
 * 测试Synchronized
 */
public class SynchronizedTest {
    // 1. 创建资源类，在资源类创建属性和操作方法
    // 2. 创建多个线程，调用资源类的操作方法

    public static void main(String[] args) {
        Ticket ticket = new Ticket(30);
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },"aa").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"bb").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"cc").start();
    }

}

class Ticket{
    private int num;

    public Ticket() {
    }

    public Ticket(int num) {
        this.num = num;
    }
    public synchronized void sale(){
        if(this.num<=0){
            System.out.println("票已卖完");
            return;
        }
        System.out.println(Thread.currentThread().getName()+": 卖出"+(this.num--) + " 剩下："+this.num+"\n");
    }
}






















