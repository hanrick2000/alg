/*
Given an integer array nums with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.
The different sequences are counted as different combinations.
Example
Given nums = [1, 2, 4], target = 4
The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]
return 6
*/

public class Solution {
    public int backPackVI(int[] nums, int target) {
        //state
        int[] f = new int[target + 1]; //f[i]表示填满背包容量是i的方案综述
        //init
        f[0] = 1;
        //fuction
        for (int i = 1; i <= target; ++i)
            for (int  j = 0; j < nums.length; ++j)
                if (i >= nums[j])
                    f[i] += f[i - nums[j]]; // f[i] = sum(f[j]) where i-num[j]>=0,  dp[4]可以分为3个情况, 1+dp[3], 2+dp[2], 4+dp[0]
        //result
        return f[target];
    }
}

//http://www.cnblogs.com/grandyang/p/5705750.html
