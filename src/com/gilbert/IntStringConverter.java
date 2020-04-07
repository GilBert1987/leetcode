package com.gilbert;

public class IntStringConverter {

    public static void  main(String[] args) {
        System.out.println(getFromString("123"));
        System.out.println(getFromString("-123"));
    }

    public static Integer getFromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        boolean isBelow0 = str.charAt(0) == '-' ? true : false;
        int start = isBelow0 ? 1: 0;
        Integer value = 0;
        for (int i = start; i < str.length(); i++) {
            value = value * 10 + (str.charAt(i) - 48);
        }
        return isBelow0 ? -1 * value : value;
    }
}