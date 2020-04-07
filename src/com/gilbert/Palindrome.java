package com.gilbert;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//        说明：本题中，我们将空字符串定义为有效的回文串。
//
//        示例 1:
//
//        输入: "A man, a plan, a canal: Panama"
//        输出: true
//        示例 2:
//
//        输入: "race a car"
//        输出: false
public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() ==0) {
            return true;
        }
        if (s.length() == 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!isAlpha(s.charAt(l)) && !isNumber(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isAlpha(s.charAt(r)) && !isNumber(s.charAt(r))) {
                r--;
                continue;
            }
            if (isSame(s.charAt(l), s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isAlpha(char s) {
        if ((s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z')) {
            return true;
        }
        return false;
    }

    private boolean isNumber(char s) {
        if ((s >='0' && s<='9')) {
            return true;
        }
        return false;
    }

    private boolean isSame(char s1, char s2) {
        if(isAlpha(s1) && isAlpha(s2)) {
            return Math.abs(s1 -s2) == 0 || Math.abs(s1 -s2) == Math.abs('A' - 'a');
        } else if (isNumber(s1) && isNumber(s2)) {
            return Math.abs(s1 -s2) == 0;
        }
        return false;
    }

    public static void main(String[] argv) {
        //System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Palindrome().isPalindrome("Zeus was deified, saw Suez."));

    }
}
