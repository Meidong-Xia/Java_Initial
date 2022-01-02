package com.dong.scanner;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        // 我们可以输入多个数字，并求其总和和平均数，每输入一个数字用回车确认，
        // 通过输入非数字来结束输入并输出执行结果。

        double sum = 0.0;
        double avg = 0.0;
        int count = 0;
        // 创建一个scanner对象
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入：");
        while(scanner.hasNextInt()) {
            sum+=scanner.nextInt();
            count++;
            System.out.println("请输入：");
        }
        avg = sum / count;
        System.out.println("和是："+sum+'\n'+"平均数是："+avg);

        scanner.close();


    }
}
