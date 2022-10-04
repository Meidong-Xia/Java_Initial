package com.dong.sync;

/**
 * @author MeidongXia
 * @date 2022/2/17 12:15
 */
public class UserTest {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        // 设置成守护线程
        aa.setDaemon(true);

        aa.start();
        System.out.println(Thread.currentThread().getName()+" over");
    }
}
