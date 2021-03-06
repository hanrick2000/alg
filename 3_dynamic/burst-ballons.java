public class Solution {
    public int maxCoins(int[] iNums) {
        int n = iNums.length;
        int[] nums = new int[n + 2]; //把iNums扩展成nums, nums只是在iNums两边各加上1
        for (int i = 0; i < n; i++) {
            nums[i + 1] = iNums[i];
        }
        nums[0] = nums[n + 1] = 1;
        int[][] f = new int[n + 2][n + 2]; //f[i][j]表示将区间i到j的数都清空得到的最大值
        return DP(1, n, nums, f);
    }
    public int DP(int i, int j, int[] nums, int[][] f) {
        if (f[i][j] > 0){
            return f[i][j];
        }
        for (int x = i; x <= j; x++) {
            f[i][j] = Math.max(f[i][j], DP(i, x - 1, nums, f) + nums[i - 1] * nums[x] * nums[j + 1] + DP(x + 1, j, nums, f));
        }
        return f[i][j];
    }
}


举个例子 这题f[i][j]如果表示将区间[i j]两端的数全清空的最大值
那么这一轮肯定要爆一个气球, 那肯定想到枚举爆哪个气球, 然后爆的这个气球就把区间分成两个子局面,而子局面都已经计算出来了,方程就很好写了
f[i][x-1]和f[x+1][j]是已经扎爆了的，这时x剩的左右边界是i-1和j+1


Given n balloons, indexed from 0 to n-1. 
Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. 
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.
- You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
- 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example
Given [4, 1, 5, 10]
Return 270

nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200
nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
nums = [10]          burst 10, get coins 1 * 10 * 1 = 10

Total coins 20 + 200 + 40 + 10 = 270
