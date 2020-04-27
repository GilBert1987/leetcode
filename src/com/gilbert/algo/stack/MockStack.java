package com.gilbert.algo.stack;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/implement-stack-using-queues/

//225. 用队列实现栈
//        使用队列实现栈的下列操作：
//
//        push(x) -- 元素 x 入栈
//        pop() -- 移除栈顶元素
//        top() -- 获取栈顶元素
//        empty() -- 返回栈是否为空
//        注意:
//
//        你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
//        你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
//        你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

//定义一个队列为存储队列(queue1)，另一个为中转队列(queue2)。
// 入栈时直接压入queue1中，出栈时先将除queue1最后一个元素外依次pop出队列，并压入queue2中，将留在queue1中的最后一个元素出队列即为出队元素，之后再次将queue2中的元素压回queue1中。
public class MockStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(Integer e) {
        queue1.offer(e);
    }

    public Integer pop() {
        int size = queue1.size();
        for (int i = 0; i < size -1; i++) {
            queue2.offer(queue1.poll());
        }
        int ret = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return  ret;
    }

    public static void main(String [] arg) {
        MockStack stack = new MockStack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());

        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
    // 3124
}
