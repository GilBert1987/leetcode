package com.gilbert.algo.search;

//搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
//
//        示例1:
//
//        输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
//        输出: 8（元素5在该数组中的索引）
//        示例2:
//
//        输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
//        输出：-1 （没有找到）
//        提示:
//
//        arr 长度范围在[1, 1000000]之间
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//        搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//        你可以假设数组中不存在重复的元素。
//
//        你的算法时间复杂度必须是 O(log n) 级别。
//
//        示例 1:
//
//        输入: nums = [4,5,6,7,0,1,2], target = 0
//        输出: 4
//        示例 2:
//
//        输入: nums = [4,5,6,7,0,1,2], target = 3
//        输出: -1
public class SearchInRotateArray {

    public int search(int[] nums, int target) {
        if (nums== null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = (start +end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                if (target >= nums[0]) {
                    if(nums[mid] >= nums[0]) {
                        start = mid + 1;
                    } else {
                        end = mid -1;
                    }
                } else {
                    start = mid + 1;
                }
            } else { // target < mid
                if  (target >= nums[0]){
                    end = mid -1;
                } else {
                    if (nums[mid] >= nums[0]) {
                        start = mid + 1;
                    } else {
                        end = mid -1;
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[]  ar) {
        System.out.println(new SearchInRotateArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }

}
