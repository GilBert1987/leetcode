package com.gilbert.algo.string;

import java.util.Stack;

//
public class StringWordReverse {

    //"the sky is blue"
    public static String reverseWords(String s) {
        Stack<Character> allLeters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            allLeters.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> word = new Stack<>();
        while(!allLeters.isEmpty()) {
            Character c = allLeters.pop();
            if (c == ' ') {
                sb.append(convertStack2String(word));
                continue;
            } else {
                word.push(c);
            }
        }
        sb.append(convertStack2String(word));
        return sb.toString().trim();
    }

    private static String convertStack2String(Stack<Character> st) {
        if (st.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString() + " ";
    }

    public static void main(String[] aarr) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
