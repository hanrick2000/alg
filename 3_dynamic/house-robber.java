public class Solution {
    public long houseRobber(int[] A) {
        int n = A.length;
        if(n == 0){ 
            return 0;
        }
        //state
        long[] f = new long[n + 1]; // f[i]表示前i个房子中, 偷到的最大价值.
        //init
        f[0] = 0;
        f[1] = A[0];
        //function
        for(int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + A[i - 1]); //分两种情况, 选取当前屋子i, 和不取当前屋子i，大的作为前i个房子中, 偷到的最大价值
        }
        //result
        return f[n];
    }
}

public class Solution {//使用滚动数组
    public long houseRobber(int[] A) {
        int n = A.length;
        if(n == 0) {
            return 0;
        }
        // state
        long []f = new long[2];
        // init
        f[0] = 0;
        f[1] = A[0];
        // fuction
        for(int i = 2; i <= n; i++) {
            f[i%2] = Math.max(f[(i-1)%2], f[(i-2)%2] + A[i-1]); //%2
        }
        // result
        return f[n%2]; //%2
    }
}

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.
Given a list of non-negative integers repfenting the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
Given [3, 8, 4], return 8.
Challenge 
O(n) time and O(1) memory.(用滚动数组)
*/

