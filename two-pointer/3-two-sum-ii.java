/*
Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. 
Please return the number of pairs.
Example
Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
Challenge 
Do it in O(1) extra space and O(nlogn) time.

求满足条件的总个数
*/
public class Solution {
    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target){ //必须是 > target, 不能是 >= target, 因为题目要求嘛
                ans = ans + (right - left);
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}
