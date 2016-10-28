/*
Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. 
Please return the number of pairs.
Example
Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
Challenge 
Do it in O(1) extra space and O(nlogn) time.

求满足条件的总个数
*/

//Two pointer, 对撞型, two sum类

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

 0,1,2,3,4,5,6,7
[2,3,4,5,6,7,8,9], target=13
left=2, right=9  11 <=13  left++
left=3, right=9  12 <=13  left++
left=4, right=9  13 <= 13 left++
left=5, right=9  14 > 13  ans=0+(7-3)=4 right--
left=5, right=8, 13 <= 13 left++
left=6, right=8, 14 > 13  ans=4+(6-4)=6 right--
left=6, right=7, 13 <=13 left++ 
left=7, right=7 退出循环
