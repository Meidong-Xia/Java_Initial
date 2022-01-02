package com.dong.method;

public class Demo05 {
    int i; // 自动初始化为0
    public static void main(String[] args) {
        Demo05 demo = new Demo05();
        int ans = demo.test(6);
        System.out.println(ans);
    }

    public int test(int i){
//        i++; // Java中static不可以修饰局部变量，和C++不同
//        if(i>5)
//            return;
//
//        System.out.println("Hello World");
//        test();
//        if(i==1) // 边界条件
//            return 1;
//        return i*test(i-1);
        int ans = 1;
        while(i>0){
            ans*=i;
            i--;
        }
        return ans;
    }
}
