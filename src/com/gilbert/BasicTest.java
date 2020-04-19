package com.gilbert;

/**
 * 数值还是引用
 */
public class BasicTest {

    public static void main(String[] argv) {
        String s1 = "abc";
        String s2 = new String("abc");
        Integer a = 12;
        Integer b = new Integer(12);
        System.out.println(s1 == s2);
        System.out.println(a == b);
        Integer c = new Integer(123455);
        fun(c);
        System.out.println(c);

        String str = new String("q1212");
        fun2(str);
        System.out.println(str);
    }

    public static void fun2(String i) {
        i = new String("10");
    }

    public static void fun(Integer i) {
        i = new Integer(10);
    }
}
