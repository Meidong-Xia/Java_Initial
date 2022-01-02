package com.dong.scanner;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        // 创建一个扫描器对象，用于接收键盘对象
        Scanner scanner = new Scanner(System.in);

//        System.out.println("使用next方式接收：");
//        // 判断用户有没有输入字符串
//        if(scanner.hasNext()) {
//            // 接收用户的输入next
//            String str = scanner.next();
//            System.out.println("输出的内容为："+str);
//        }

        System.out.println("使用nextLine方式接收：");
        // 判断用户有没有输入字符串
        if(scanner.hasNextLine()) {
            // 接收用户的输入nextLine
            String str = scanner.nextLine();
            System.out.println("输出的内容为："+str);
        }


        // 用完scanner就要关掉
        scanner.close();
    }
}
