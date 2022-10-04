package com.dong.security;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @author MeidongXia
 * @date 2022/2/19 10:08
 * HashSet和HashMap的线程不安全性和解决方案
 */
public class MapTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<String>();
        // 解决方案1
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }


        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(()->{
                map.put(finalI,UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }



}
