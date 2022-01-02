package com.dong.method;

import org.jetbrains.annotations.NotNull;

public class Demo04 {
    public static void main(String[] args) {
        method(1,2.3,3.4,6.7);
    }

    public static void method(int num, double... numbers){
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }

    }
}
