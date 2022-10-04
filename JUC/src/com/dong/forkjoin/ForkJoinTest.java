package com.dong.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author MeidongXia
 * @date 2022/2/20 18:26
 */
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(1, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(myTask);
        Integer integer = submit.get();

        forkJoinPool.shutdown();
        System.out.println(integer);
    }


}


class MyTask extends RecursiveTask<Integer> {

    private static final Integer VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if(this.end-this.begin<=10){
            for(int i = begin; i<=end;i++){
                this.result += i;
            }
        }else{
            int mid = begin+((end-begin)>>1);
            // 拆分左边
            MyTask t1 = new MyTask(begin,mid);
            // 拆分右边
            MyTask t2 = new  MyTask(mid+1,end);

//            t1.fork();
            t2.fork();

            // 合并
            result = t1.compute()+t2.join();

        }
        return result;
    }
}
