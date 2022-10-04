package com.dong.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author MeidongXia
 * @date 2022/2/20 14:50
 * BlockingQueueTest测试
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个阻塞队列
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // 第一组
        System.out.println(blockingQueue.offer("aa"));
        System.out.println(blockingQueue.offer("bb"));
        System.out.println(blockingQueue.offer("cc"));
        System.out.println(blockingQueue.offer("cc",3, TimeUnit.MILLISECONDS));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        blockingQueue.put("aa");
        blockingQueue.put("bb");
        blockingQueue.put("cc");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());


    }
}
