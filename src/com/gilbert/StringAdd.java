package com.gilbert;

public class StringAdd {

    public static String add(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return str1 == null ? str2 : str1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int l1 = str1.length();
        int l2 = str2.length();

        while (l1 > 0 || l2 >0 || carry > 0) {
            int temp = carry;
            if (l1 > 0) {
                l1--;
                temp += str1.charAt(l1) - '0';
            }
            if (l2 > 0) {
                l2--;
                temp += str2.charAt(l2) - '0';
            }
            carry = temp / 10;
            sb.append(temp % 10);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(StringAdd.add("3458", "19"));
    }
}
