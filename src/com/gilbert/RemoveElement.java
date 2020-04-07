package com.gilbert;

import com.sun.tools.javac.util.Assert;

public class RemoveElement {

    public static int removeElement(int [] array, int element) {
        if (array== null || array.length == 0) {
            return 0;
        }
        int k = 0;
        int p = 0;
        while (p < array.length) {
            if (array[p] != element) {
                array[k++] = array[p];
            }
            p++;
        }
        return k;
    }

    public static int removeElementLeftOne(int [] array, int element) {
        if (array== null || array.length == 0) {
            return 0;
        }
        int k = 0;
        int p = 0;
        int count = 0;
        while (p < array.length) {
            if (array[p] != element) {
                array[k++] = array[p];
            } else if(count == 0){
                array[k++] = array[p];
                count++;
            }
            p++;
        }
        return k;
    }

    public static void main(String[] ar) {
        int [] array = new int[] {1,2,3,2,4};
        int ret = removeElement(array, 2);
        Assert.check(ret == 3);

    }
}
