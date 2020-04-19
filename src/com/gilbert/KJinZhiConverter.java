package com.gilbert;

/**
 * 任意进制转换
 */
public class KJinZhiConverter {
    private static char[] chaList = new char[36];
    static {
        for(int i = 0; i < 10; i++) {
            chaList[i] = (char)(i + '0');
        }
        for (int i = 10; i < chaList.length; i++) {
            chaList[i] = (char)((i - 10) + 'A');
        }
        System.out.println(chaList);
    }
    public String convert(int num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(chaList[num % k]);
            num = num / k;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] argv){
        System.out.println(new KJinZhiConverter().convert(10, 10));
        System.out.println(new KJinZhiConverter().convert(1234, 36));
        System.out.println(new KJinZhiConverter().convert(1234, 34));
    }
}
