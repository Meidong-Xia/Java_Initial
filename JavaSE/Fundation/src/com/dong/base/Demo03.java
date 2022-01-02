package com.dong.base;

/**
 * @author Meidong Xia
 * @version 1.0
 * @since 1.8
 */

public class Demo03 {
    public static void main(String[] args) {
        // 整数拓展，进制 二进制0b，十进制，八进制0，十六进制0x

        int i = 10;
        int i2 = 010; // 八进制0
        int i3 = 0x10; // 十六进制0x
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        //=================================================================================
        // 浮点数拓展 银行业务钱怎么表示 BigDecimal 数学工具类
        // float 有限的 离散的 舍入误差 接近但不等于
        // double
        // 最好完全不使用浮点数float进行比较
        // 最好完全不使用浮点数float进行比较
        //=================================================================================

        float f = 0.1f;
        double d = 1.0/10;
        System.out.println(f==d); // ??? false
        System.out.println(f);
        System.out.println(d);

        float d1 = 231313131313131f;
        float d2 = d1+1;
        System.out.println(d1==d2); // ??? true

        //=================================================================================
        // 字符拓展
        // 所有的字符本质还是数字
        // 编码 unicode 表 97=a 65=A 2字节 0~65536 Excel 2^12 = 65536
        // U0000 UFFFF
        // 转义字符： \t tab, \n 换行,
        //=================================================================================
        char c1 = '中';
        char c2 = 'a';
        char c3 = '\u0061'; // 这就是unicode编码

        System.out.println(c3);

        System.out.println(c1);
        System.out.println((int)(c1));

        System.out.println(c2);
        System.out.println((int)(c2));

        String sa = new String("Hello World");
        String sb = new String("Hello World");
        System.out.println(sa==sb); // 从内存角度 false

        String sc = "Hello World";
        String sd = "Hello World";
        System.out.println(sc==sd); // true

        //=================================================================================
        //布尔值拓展
        // if(flag)==if(flag==true)
        //=================================================================================

        boolean flag = true;
        // if(flag)
        // Less is more

    }
}
