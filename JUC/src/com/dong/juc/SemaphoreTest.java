package com.dong.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author MeidongXia
 * @date 2022/2/19 19:04
 * SemaphoreTest测试
 *
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 创建Semaphore, 设置许可数量
        Semaphore semaphore = new Semaphore(3);
        // 模仿6辆汽车停三个停车位
        for (int i = 0; i < 7; i++) {
            new Thread(()->{

                // 抢占
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"  抢到了车位");
                    // 随机设置停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName()+"  离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    // 释放
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }

}
