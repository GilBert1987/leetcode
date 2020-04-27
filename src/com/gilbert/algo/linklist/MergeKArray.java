package com.gilbert.algo.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//        示例:
//
//        输入:
//        [
//          1->4->5,
//          1->3->4,
//          2->6
//        ]
//        输出: 1->1->2->3->4->4->5->6
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// https://leetcode-cn.com/problems/merge-k-sorted-lists/

/**
 * 海量数据 三板斧 Hash 大小 Hash 算法的选择  数据量/内存  1024   排序 K 路归并 堆排序
 *
 * 最多的K 小顶堆  最小的K 大顶堆
 */

/**
 * K 路归并程序
 */
public class MergeKArray {
    public static List<Integer> mergeKArray(List<Integer[]> list) {
        List<Integer> ret = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return ret;
        }
        int [] pos = new int[list.size()];
        boolean remainElem = true;
        while (remainElem) {
            int minElem = Integer.MAX_VALUE;
            int minPos = 0;
            for (int i = 0 ; i< list.size(); i++) {
                if(pos[i] < list.get(i).length) {
                    int elem = list.get(i)[pos[i]];
                    if (elem < minElem) {
                        minElem = elem;
                        minPos = i;
                    }
                }
            }
            if (minElem != Integer.MAX_VALUE) {
                ret.add(minElem);
                pos[minPos]++;
            } else {
                remainElem = false;
            }
        }
        return ret;
    }

    public static void main(String[] argv) {
       String ret =  new MergeKArray().mergeKArray(Arrays.asList(new Integer[]{1,3,5}, new Integer[]{2,4,6}, new Integer[]{7}, new Integer[]{0, 10})).stream().map(e -> e + ",").collect(Collectors.joining());
       System.out.println(ret);
    }
}
