package com.dong.method;

public class Demo01 {
    public static void main(String[] args) {
//        int sum = add(1,2);
//        System.out.println(sum);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public static int add(int x, int y) {
        return x+y;
    }
}
