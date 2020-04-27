package com.gilbert.algo.string;

//14. 最长公共前缀
//        编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//        示例 1:
//
//        输入: ["flower","flow","flight"]
//        输出: "fl"
//        示例 2:
//
//        输入: ["dog","racecar","car"]
//        输出: ""
//        解释: 输入不存在公共前缀。

//        https://leetcode-cn.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonPrex = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrex = commonPrefix(commonPrex, strs[i]);
        }
        return commonPrex;
    }

    private String commonPrefix(String str1, String str2) {
        StringBuilder sb =new StringBuilder();
        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++,j++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] argv) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
}
