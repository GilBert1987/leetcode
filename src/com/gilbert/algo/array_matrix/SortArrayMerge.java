package com.gilbert.algo.array_matrix;

import java.util.Arrays;

public class SortArrayMerge {

    public static int[] merge(int [] a, int [] b) {
        int aLength = a != null ? a.length : 0;
        int bLegth = b!= null ? b.length :0;
        if (aLength + bLegth == 0) {
            return null;
        }
        int [] ret = new int[aLength + bLegth];
        int k = 0;
        int i = 0, j = 0;
        for (; i< aLength && j < bLegth;) {
            if(a[i] < b[j]) {
               ret[k++] =a[i++];
            } else {
                ret[k++] = b[j++];
            }
        }
        if (i >= aLength) {
            if(j < bLegth) {
                ret[k++] = b[j++];
            }
        }
        if (j >= bLegth) {
            if(i < aLength) {
                ret[k++] = a[i++];
            }
        }
        return ret;
    }



    public static void main(String [] args) {
        Arrays.stream(merge(new int[]{1, 3, 6}, new int[]{2, 4, 8})).forEach(e -> System.out.println(e));
    }
}
