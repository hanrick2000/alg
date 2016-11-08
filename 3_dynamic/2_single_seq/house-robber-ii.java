public class Solution {
    public int houseRobber2(int[] nums) {
        if (nums.length == 0){
            return 0;
        } else if (nums.length == 1){
            return nums[0];
        }
       return Math.max(robber1(nums, 0, nums.length - 2), robber1(nums, 1, nums.length - 1));
    }
    //my version
    public int robber1(int[] A, int st, int ed) {
        int n = ed - st + 1;
        //state
        int[] f = new int[n + 1]; // f[i]表示前i个房子能偷到的最大价值
        //init
        f[0] = 0;
        f[1] = A[st];
        //fuction
        for(int i = 2; i <= n; i++){
          f[i] = Math.max(f[i - 1], f[i - 2] + A[st + i - 1]);
        }
        //result
        return f[n];
    }
}

public class Solution {
    public int houseRobber2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robber1(nums, 0, nums.length - 2), robber1(nums, 1, nums.length - 1));
    }
    // my rolling array version
    public int robber1(int[] nums, int st, int ed) {
        int n = ed - st + 1;
        int[] f = new int[2];
        f[0] = 0;
        f[1] = nums[st];
        for(int i = 2; i <= n; i++){
          f[i % 2] = Math.max(f[(i - 2) % 2]+nums[st + i - 1], f[(i - 1) % 2]);
        }
        return f[n % 2];
    }
}
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
