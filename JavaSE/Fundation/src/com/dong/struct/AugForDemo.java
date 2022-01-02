package com.dong.struct;

public class AugForDemo {
    public static void main(String[] args) {
        int[] numbers = new int[10]; // 默认值是0，new是先分配内存，再去执行构造函数？和C++一样？
        for(int x:numbers){
            System.out.println(x);
        }
    }
}
