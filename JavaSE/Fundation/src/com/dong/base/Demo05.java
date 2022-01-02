package com.dong.base;

public class Demo05 {
    public static void main(String[] args) {
        int i = 128;
        // byte b = i; 报错
        byte b = (byte)i; // 强制类型转换
        System.out.println(b); // -128
        System.out.println(i); // 128 最高位是符号位 内存溢出

        System.out.println((int)23.7); // 23
        System.out.println((int)-45.89f); // -45

        char a = 'a';
        int d = a+1;
        System.out.println(d);
        System.out.println((int)d);

        double c = i;
        System.out.println(c); // 128.0
        /*
        注意点：
        1. 不能对boolean进行转换
        2. 不能把对象类型转换成不相关的类型
        3. 高->低 强制类型转换，可能会存在内存溢出或者精度问题
        4. 低->高 自动类型转换
         */



    }
}
