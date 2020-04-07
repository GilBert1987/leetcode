package com.gilbert;
//11. 盛最多水的容器

import com.sun.tools.javac.util.Assert;

public class MaxArea {

    public static int area(int [] array) {
        int maxArea = 0;
        if (array == null || array.length == 0 || array.length == 1) {
            return maxArea;
        }
        int p = 0;
        int q = array.length -1;
        while (p < q) {
            int area = Math.min(array[p], array[q]) * (q - p);
            maxArea = Math.max(maxArea, area);
            if (array[p] < array[q]) {
                p++;
            } else {
                q--;
            }
        }
        return maxArea;
    }

    public static void main(String[] arr) {
        Assert.check(area(new int[] {1,8,6,2,5,4,8,3,7}) == 49);
    }
}
