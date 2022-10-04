package com.dong.completefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author MeidongXia
 * @date 2022/2/20 19:47
 */
public class CompleteFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 异步调用，没有返回值
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " CompletableFuture");
        });


        completableFuture.thenCompose();

        completableFuture.get();

        // 异步调用，有返回值
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " CompletableFuture");
            return 1024;
        });

        completableFuture2.whenComplete((t,u)->{
            System.out.println(t+" "+u); // t是方法返回值，u是异常
        }).get();

    }
}
