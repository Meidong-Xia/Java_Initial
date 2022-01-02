package com.dong.base;

public class Demo08 {
    int a = 8; // 实例变量，会有一个默认值，数值类型默认值是0或者0.0，布尔值默认false，引用类型默认值都是null.
    static int b = 200; // 类变量，类变量可以直接输出，也会有默认值
    final static int INT_BYTE = 127; // 修饰符不考虑次序位置
    public static void main(String[] args) throws Exception {
        // static 函数里面可以处理局部变量
        int c = add(2,3); // static函数里面只能处理static函数
        System.out.println(c);

        System.out.println(b); // static可以输出
        // System.out.println(a); // 错！！！static函数里面只能处理static变量
    }

    /**
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    public static int add(int a, int b) throws Exception {

        return a+b;
    }

    public void test(){
        System.out.println(a); // 可以输出
        // INT_BYTE = 20; // 不可以更改
    }
}
