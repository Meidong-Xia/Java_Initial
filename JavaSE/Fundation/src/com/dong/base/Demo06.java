package com.dong.base;

public class Demo06 {
    public static void main(String[] args) {
        // 操作比较大的时候，注意溢出问题
        // JDK7新特性，数字之间可以用下划线区分
        int money =  10_0000_0000;
        int year = 20;
        int total = money*year; //-1474836480 溢出
        long total1 = money*year; // -1474836480 溢出
        long total2 = money*((long)year); //20000000000 正确输出
        System.out.println(total);
        System.out.println(total1);
        System.out.println(total2);
    }
}
