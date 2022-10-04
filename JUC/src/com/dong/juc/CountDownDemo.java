package com.dong.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author MeidongXia
 * @date 2022/2/19 17:26
 * 演示CountDownLatch
 */
public class CountDownDemo {
    public static void main(String[] args) throws InterruptedException {
        // 六个同学离开教室之后，班长才可以锁门
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await(); // 等待减少到0才可以往下运行
        System.out.println("结束");
    }
}
