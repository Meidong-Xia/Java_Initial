package com.dong.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author MeidongXia
 * @date 2022/2/20 11:51
 * 测试读写锁，写锁的降级
 */
public class LockDegradeTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

        // 锁降级的过程
        // 写锁
        writeLock.lock();

        // 读锁     获得写锁之后可以获得读锁，但是反过来不可以
        readLock.lock();

        System.out.println("dong");

        // 释放写锁
        writeLock.unlock();

        // 释放读锁
        readLock.unlock();
    }
}
