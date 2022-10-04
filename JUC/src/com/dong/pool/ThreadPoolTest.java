package com.dong.pool;


import java.util.concurrent.*;

/**
 * @author MeidongXia
 * @date 2022/2/20 16:20
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        // 一池N线程
//        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
//
//        // 一池1线程
//        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        // 一池可扩容的线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();


        // 自定义线程池
        ExecutorService threadPool4 = new ThreadPoolExecutor(
                3,
                5,
                100L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        // 10个顾客
        try{
            for (int i = 10; i > 0; i--) {
                int finalI = i;
                threadPool4.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"  "+ finalI );
                });

            }

        }finally{
            threadPool4.shutdown();
        }

    }
}
