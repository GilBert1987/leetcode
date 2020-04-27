package com.gilbert.algo.heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 出现频率最大的K个单词
 */
public class TopKWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);// getOrDefault
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );
        // 注意出现次数相同的话，也需要比较字符串 字符串比较注意是

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll(); // 注意这里弹出的都是比较小的元素，所以剩下的都是大的
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);// 注意需要reverse
        return ans;
    }

    public static void printList(List<String> data) {
        System.out.println(data.stream().map(e -> e + ",").collect(Collectors.joining()));
    }

    public static void main(String [] argv) {
        TopKWords.printList(new TopKWords().topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 3));
    }
}
