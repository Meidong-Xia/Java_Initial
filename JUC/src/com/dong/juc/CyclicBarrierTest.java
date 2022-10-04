package com.dong.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author MeidongXia
 * @date 2022/2/19 18:40
 * CyclicBarrierTest测试
 *  设置一个固定值，以及到达固定值以后要做什么事情
 */
public class CyclicBarrierTest {
    private static final int  NUM = 7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM, () -> {
            System.out.println("召唤");
        });
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
