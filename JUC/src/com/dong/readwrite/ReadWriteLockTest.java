package com.dong.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author MeidongXia
 * @date 2022/2/20 9:55
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.get(String.valueOf(1));
            },String.valueOf(finalI)).start();
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.put(String.valueOf(finalI), finalI);

            },String.valueOf(finalI)).start();
        }




    }
}

// 创建一个资源类
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();
    // 创建一个读写锁
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void put(String key, Object value){
        // 写锁
        rwLock.writeLock().lock();


        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(900));
            System.out.println(Thread.currentThread().getName()+" 正在写操作 "+key);
            map.put(key,value);
            System.out.println("已经写完数据 " + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();
        }

    }

    public Object get(String key){
        rwLock.readLock().lock();
        Object res = null;
        try {
            System.out.println("正在读 "+key);
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            res = map.get(key);
            System.out.println("已经取完了 "+key);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();
        }
        return res;
    }
}
