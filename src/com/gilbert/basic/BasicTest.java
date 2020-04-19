package com.gilbert.basic;

import java.util.Arrays;
import java.util.List;

/**
 * 问题 传递是数值还是引用
 */
public class BasicTest {
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "|" + y;
        }
    }

    public static void function(int i, Integer a, String b, List<Integer> c, Point point) {
        i += 3;
        a += 3;
        b +="3";
        c = Arrays.asList(3);
        point.x = 3;
        point.y = 3;
    }

    /**
     * 如果传递的是引用的话，String 和 Integer 为什么没有变化
     * @param argv
     */
    public static void main(String[] argv) {
        int i = 1;
        Integer a = new Integer(1);
        String b =new String("1");
        List<Integer> c = Arrays.asList(1);
        Point p = new Point(1,1);
        BasicTest.function(i, a, b, c, p);
        System.out.println(i+","+ a+","+b+","+c +"," + p);
    }
}
