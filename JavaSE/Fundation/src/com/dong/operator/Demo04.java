package com.dong.operator;

public class Demo04 {
    public static void main(String[] args) {
        /* 位运算符
        A = 0011 1100
        B = 0000 1101
        2*8 就用位运算，快速乘
         */

        // 字符串连接符 + String
        int a = 10;
        int b = 20;
        System.out.println(""+a+b);// 1020 连接起来
        System.out.println(a+b+"");// 30 计算之后连起来
        System.out.println(a+""+b);// 1020 只要有一个String类型，就认为 + 是字符串连接符


    }
}
