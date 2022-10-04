package com.dong.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author MeidongXia
 * @date 2022/2/19 15:14
 * 比较Callable接口和Runnable接口的不同
 */
public class Demo1<T>{
    public static void main(String[] args) {
        new Thread(new MyThread1(),"aa").start();
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println("bb");
            return 1024;
        });
        new Thread(futureTask,"aa").start();

        while(!futureTask.isDone()){
            System.out.println("waiting");
        }

        try {
            System.out.println(futureTask.get());
            System.out.println(futureTask.get()); // 只需要计算一次
            System.out.println(Thread.currentThread().getName()+" come over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }



}

class MyThread1 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("bb");
        return 1;
    }
}
