package com.gilbert;

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
