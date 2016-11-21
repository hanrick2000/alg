public class Solution {
    public int numWays(int n, int k) {
        if(n <= 0 || k <= 0){
            return 0;
        }
        if(n == 1){
            return k;
        }
        //state, f[i]表示前i个桩子有多少种刷法
        int[] f = new int[n + 1];
        //init
        f[0] = 0;
        f[1] = k;
        f[2] = k + k * (k - 1); //也是分成相同和不同
        //function
        for(int i = 3; i <= n; i++){
            f[i] = (k - 1) * (f[i - 1] + f[i - 2]);
        }
        //result
        return f[n];
    }
}

/*
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color. (注意哦, 是不能让大于两个相邻的柱子有相同的颜色)
Return the total number of ways you can paint the fence.
Note:
n and k are non-negative integers.
Company Tags Google
Tags Dynamic Programming
Similar Problems (E) House Robber (M) House Robber II (M) Paint House (H) Paint House II

分析过程
第i个柱子的刷法个数f[i] = S[i] + D[i]
S[i]表示第i个柱子跟前一个相同时的方案数
D[i]表示第i个柱子跟前一个不同时的方案数
因为第i个跟i-1颜色相同时, i-1跟i-2的颜色一定不相同, 所以S[i] = D[i-1] 
当第i个跟前一个颜色不同时, 第i个有k-1种刷法, i-1有f[i-1]种刷法
则f[i] = D[i-1] + (k-1)*f[i-1]
       = (k-1)*f[i-2] + (k-1)*f[i-1]
       = (k-1)*(f[i-1]+f[i-2])

*/
