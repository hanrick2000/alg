/*
After robbing those houses on that street, 
the thief has found himself a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.
Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
This is an extension of House Robber.
Have you met this question in a real interview? Yes
nums = [3,6,4], return 6
*/
public class Solution {
    public int houseRobber2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robber1(nums, 0, nums.length - 2), robber1(nums, 1, nums.length - 1));
    }
    public int robber1(int[] nums, int st, int ed) {
        if(st == ed) return nums[ed];
        if(st+1 == ed) return Math.max(nums[st], nums[ed]);
        int[] f= new int[2];
        f[st%2] = nums[st];
        f[(st+1)%2] = Math.max(nums[st], nums[st+1]);
        for(int i = st+2; i <= ed; i++) {
            f[i%2] = Math.max(f[(i-1)%2], f[(i-2)%2] + nums[i]);
        }
        return f[ed%2];
    }
}
