package com.dong.mysql;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author MeidongXia
 * @date 2022/2/22 16:39
 */
public class JavaMySQL {
    public static void main(String[] args) {


        System.out.println(isValid("()"));


        StringBuilder stringBuilder = new StringBuilder();


    }



    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        char[] str = s.toCharArray();

        for(char c:str){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if(stack.empty() || stack.peek() != c){
                return false;
            }else{
                stack.pop();
            }
        }


        return true;
    }

}
