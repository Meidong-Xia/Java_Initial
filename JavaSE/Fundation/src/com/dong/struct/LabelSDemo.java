package com.dong.struct;

public class LabelSDemo {
    public static void main(String[] args) {
        // 打印101-150之间的所有质数
        int cnt = 0;
        outer:for(int i=101;i<150;i++){
            for(int j=2;j*j<i;j++){
                if(i%j==0){
                    continue outer; // 跳到outer标签处
                }
            }
            System.out.println(i);
        }
    }
}
