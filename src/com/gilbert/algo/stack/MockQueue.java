package com.gilbert.algo.stack;

import java.util.Stack;
import java.util.stream.IntStream;

//使用栈实现队列的下列操作：
//
//        push(x) -- 将一个元素放入队列的尾部。
//        pop() -- 从队列首部移除元素。
//        peek() -- 返回队列首部的元素。
//        empty() -- 返回队列是否为空。
//        示例:
//
//        MyQueue queue = new MyQueue();
//
//        queue.push(1);
//        queue.push(2);
//        queue.peek();  // 返回 1
//        queue.pop();   // 返回 1
//        queue.empty(); // 返回 false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//利用栈last in first out 的特性，使用两个栈可以实现队列的pop和push操作。
// 输入3125
// 栈1:3125
// 输出 结果 3
// 栈2 5213 输出 3
//栈2  521
// 栈1 空
// 输入 8
// 栈一 8
// 栈二 521
// 输出 1

public class MockQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(Integer e) {
        stack1.push(e);
    }

    public Integer pop() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                int p = stack1.pop();
                stack2.push(p);
            }
        }
        return stack2.pop();
    }

    public static void main(String [] arg) {
        MockQueue queue = new MockQueue();

        IntStream.range(8, 50).forEach(e -> queue.push(e));

        System.out.println(queue.pop());
    }
}
