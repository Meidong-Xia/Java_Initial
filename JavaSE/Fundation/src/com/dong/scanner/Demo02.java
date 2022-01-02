package com.dong.scanner;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        // 创建一个scanner对象
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;

        // 输入整数
        System.out.println("请输入整数：");
        if(scanner.hasNextInt()) {
            i = scanner.nextInt();
            System.out.println("整数数据："+i);
        }else{
            System.out.println("输入的不是整数");
        }

        // 输入小数
        System.out.println("请输入小数：");
        if(scanner.hasNextFloat()) {
            f = scanner.nextFloat();
            System.out.println("小数数据："+f);
        }else{
            System.out.println("输入的不是小数");
        }


        scanner.close();
    }
}
