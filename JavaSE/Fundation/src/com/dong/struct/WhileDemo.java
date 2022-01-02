package com.dong.struct;

public class WhileDemo {
    public static void main(String[] args) {
        int i=0;
        int sum = 0;
        // do while循环至少执行一次
        do{
            sum+=i;
            i++;
        }while(i<=100);

        System.out.println(sum);
    }
}
