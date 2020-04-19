package com.gilbert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode/
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        backTrace(numList, 0, ret);
        return ret;
    }

    private void backTrace(List<Integer> nums, int first, List<List<Integer>> ret) {
        if (first == nums.size()) {
            ret.add(new ArrayList<>(nums));
            return;
        }
        for (int i = first; i < nums.size(); i++) {
            Collections.swap(nums, i, first);
            backTrace(nums, first + 1, ret);
            Collections.swap(nums, i, first);
        }
    }

    public static void main(String[] argv) {
        List<List<Integer>> rert;
        rert = new Permute().permute(new int[] {1,2,3});
        rert.stream().forEach(e -> System.out.println(e.stream().map(s -> s + ",").collect(Collectors.joining())));
    }
}
