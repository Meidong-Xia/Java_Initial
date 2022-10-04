package com.dong.security;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author MeidongXia
 * @date 2022/2/17 17:55
 * 集合的线程安全问题
 */
public class CollectionTest {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<String>();
//
//        for (int i = 10; i > 0; i--) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,8));
//
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }

//        List<String> list = new Vector<String>();
//
//        for (int i = 10; i > 0; i--) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,8));
//
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }


//        List<String> list = Collections.synchronizedList(new ArrayList<String>());
//
//        for (int i = 10; i > 0; i--) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,8));
//
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }

        List<String> list = new CopyOnWriteArrayList<String>();

        for (int i = 10; i > 0; i--) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));

                System.out.println(list);
            }, String.valueOf(i)).start();
        }


    }


}
