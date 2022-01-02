package com.dong.operator;

public class Demo03 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        System.out.println("a+b=:"+ (a&&b));
        // 注意短路运算
        int c = 5;
        boolean d = (c<4)&&(c++<6);
        System.out.println(c); // 5 注意上面的c++没有执行，被短路了
    }
}
