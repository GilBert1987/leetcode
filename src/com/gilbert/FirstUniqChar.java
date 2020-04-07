package com.gilbert;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
//
//        示例:
//
//        s = "abaccdeff"
//        返回 "b"
//
//        s = ""
//        返回 " "
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class FirstUniqChar {
    class InnerStruct{
        Integer count;
        Integer pos;
        public InnerStruct() {
            count = 0;
            pos = null;
        }
    }
    public char firstUniqChar(String s) {
        InnerStruct[] innerStructs = new InnerStruct[256];
        for (int i = 0; i< s.length(); i++) {
            InnerStruct struct = innerStructs[s.charAt(i)];
            if (struct == null) {
                struct = new InnerStruct();
                innerStructs[s.charAt(i)] = struct;
            }
            struct.count++;
            if (struct.pos == null) {
                struct.pos = i;
            }
        }
        int minPos = Integer.MAX_VALUE;
        for (int i = 0; i< innerStructs.length; i++) {
            if (innerStructs[i] != null && innerStructs[i].count == 1) {
                minPos = Math.min(minPos, innerStructs[i].pos);
            }
        }
        if (minPos == Integer.MAX_VALUE) {
            return ' ';
        }
        return s.charAt(minPos);
    }

    public static void main(String[] ar) {
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));

        System.out.println(new FirstUniqChar().firstUniqChar("abaccdeff"));
        System.out.println(new FirstUniqChar().firstUniqChar(""));
        System.out.println(new FirstUniqChar().firstUniqChar("CC"));
    }
}
