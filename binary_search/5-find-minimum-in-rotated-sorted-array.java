/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
Notice
You may assume no duplicate exists in the array.
*/
/*
 跟search in rotated sorted array很像
 都是根据nums[mid]和nums[nums.length-1](也可以是nums[0])来判断哪边是有序的
 最后剩下的两个, 选小的就是最小值
   0 1
   1 0
*/
public class Solution {
  /**
   * @param num: a rotated sorted array
   * @return: the minimum number in the array
   */
  public int findMin(int[] nums) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return -1;
    }
    
    int start = 0;
    int end = nums.length - 1;
    int target = nums[nums.length - 1];
    
    // find the first element <= target
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] <= target) {
        end = mid;
      } else {
        start = mid;
      }
    }
    if (nums[start] <= target) {
      return nums[start];
    } else {
      return nums[end];
    }
  }
}
