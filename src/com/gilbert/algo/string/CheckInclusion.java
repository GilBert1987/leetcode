package com.gilbert.algo.string;

// LeetCode-567 字符串的排列

//https://www.jianshu.com/p/846c50c1c0ab

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//        换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
//        示例:
//        示例1:
//        输入: s1 = "ab" s2 = "eidbaooo"
//        输出: True
//        解释: s2 包含 s1 的排列之一 ("ba").
//        示例2:
//        输入: s1= "ab" s2 = "eidboaoo"
//        输出: False
//
//        注意：
//        输入的字符串只包含小写字母
//        两个字符串的长度都在 [1, 10,000] 之间
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] cnt1=new int[26];
        int[] cnt2=new int[26];
        //窗口大小为s1的长度，建立窗口
        for(int i=0;i<s1.length();++i){
            cnt1[s1.charAt(i)-'a']++;
            cnt2[s2.charAt(i)-'a']++;
        }
        int[] diff=new int[26];
        for(int i=0;i<diff.length;++i){
            diff[i]=cnt2[i]-cnt1[i];
        }
        for(int i=s1.length();i<s2.length();++i){
            if(isSame(diff)){
                return true;
            }
            //对窗口进行移动。
            diff[s2.charAt(i - s1.length()) - 'a']--;
            diff[s2.charAt(i) - 'a']++;
        }
        return isSame(diff);
    }
    //判断s2中的字符和s1长度相等的并且字符出现次数都相等说明s1和这一段子串的排序之一
    public boolean isSame(int[] diff) {
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] argv) {
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidbaooo"));
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidboaoo"));
    }
}
