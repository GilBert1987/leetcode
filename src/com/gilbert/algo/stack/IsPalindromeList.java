package com.gilbert.algo.stack;

import com.gilbert.algo.linklist.ListUtils;
import com.gilbert.algo.linklist.ListNode;

import java.util.Stack;

// LC-234. 回文链表
public class IsPalindromeList {

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> ret = new Stack<>();
        ListNode p = head;
        while (p != null) {
            ret.push(p.val);
            p = p.next;
        }
        ListNode q = head;
        while (!ret.isEmpty() && q != null) {
            int val = ret.pop();
            if (val != q.val) {
                return false;
            }
            q = q.next;
        }
        if (q != null || !ret.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] argv) {
        System.out.println(new IsPalindromeList().isPalindrome(ListUtils.buildFromArray(new int [] {1,2,2,1})));
        System.out.println(new IsPalindromeList().isPalindrome(ListUtils.buildFromArray(new int [] {1,2})));
        System.out.println(new IsPalindromeList().isPalindrome(ListUtils.buildFromArray(new int [] {2,2})));
        System.out.println(new IsPalindromeList().isPalindrome(ListUtils.buildFromArray(new int [] {1,0, 0})));
        System.out.println(new IsPalindromeList().isPalindrome(ListUtils.buildFromArray(new int [] {1,0, 1})));

    }

}
