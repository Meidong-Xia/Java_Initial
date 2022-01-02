package com.dong.struct;

public class SwitchDemo {
    public static void main(String[] args) {
        String grade = "A";
        // JDK7之后，表达式的结果可以是字符串
        // case穿透
        // 反编译，java->class（字节码文件）->反编译（IDEA）
        switch(grade){
            case "A":
                System.out.println("优秀");
                break;
            case "B":
                System.out.println("还行");
                break;
            default:
                System.out.println("不及格");
        }
    }
}
