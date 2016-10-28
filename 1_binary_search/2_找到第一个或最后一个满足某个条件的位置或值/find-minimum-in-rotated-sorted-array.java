public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) { //剩下两个值时退出
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {//mid右边有序,则下轮在mid左边搜索
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        }else {
            return nums[end];
        }
    }
}

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
Notice
You may assume no duplicate exists in the array.

 跟search in rotated sorted array很像
 都是根据nums[mid]和nums[nums.length-1](也可以是nums[0])来判断哪边是有序的
 最小值一定落在无序的那边
 在不断二分缩小查找范围后, 剩下两个值, 一定是rotated array翻转的地方
 最后剩下的两个, 选小的就是最小值
   0 1
   1 0
   [1 2 3]
   [3 1 2]
       /|
      / |
     /  |
    /   |
   /    |
  /     |
 /      |
--------|------
        |   /
        |  /
        | /
        |/


    /|
   / |
  /  |
 /   |
-----|----------
     |        /
     |       /
     |      /
     |     /
     |    /
     |   /
     |  /
     | /
     |/
*/
