package com.gilbert;

import java.util.LinkedList;
import java.util.Queue;

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
