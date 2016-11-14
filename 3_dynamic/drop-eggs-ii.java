public class Solution {
    /**
     * @param m the number of eggs
     * @param n the umber of floors
     * @return the number of drops in the worst case
     */
    public int dropEggs2(int m, int n) {
        // Write your code here
        int[][] f = new int[m + 1][n + 1]; //f[i][j]表示剩i个蛋, 剩j层时最少的尝试次数

        for (int i = 1; i <= m; ++i) { //不管几个蛋时, 第0和1层的尝试个数
            f[i][1] = 1;
            f[i][0] = 0;
        }
     
        for (int j = 1; j <= n; ++j) { //1个蛋的时候, 各层的尝试次数都是层高
            f[1][j] = j;
        }

        for (int i = 2; i <= m; ++i) { //枚举蛋
            for (int j = 2; j <= n; ++j) { //枚举层
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; ++k) { //让当前层的各种情况打擂台
                    f[i][j] = Math.min(f[i][j], 1 + Math.max(f[i - 1][k - 1], f[i][j - k]));
                    //                                       碎了,            没碎
                }
            }
        }

        return f[m][n];
    }
}

//当有i个蛋, 在第j层时的最小尝试次数, 需要枚举1到j层时扔蛋的情况(用k表示枚举的层), 比如在第k层扔了, 碎了那么还剩i-1个蛋, 剩下k-1层需要尝试. 如果没有碎, 还剩下i个蛋, 剩下j-k层需要尝试

/*
There is a building of n floors. 
If an egg drops from the k th floor or above, it will break. 
If it's dropped from any floor below, it will not break.
You're given m eggs, Find k while minimize the number of drops for the worst case. 
Return the number of drops in the worst case.

Example
Given m = 2, n = 100 return 14
Given m = 2, n = 36 return 8

Tags 
Dynamic Programming
*/


动态规划的方法，可以推广为n层楼，m个鸡蛋。
如下分析： 假设f{n,m}表示n层楼、m个鸡蛋时找到最高楼层的最少尝试次数。
当第一个鸡蛋从第i层扔下，
如果碎了，还剩m-1个鸡蛋，为确定下面楼层中的安全楼层，还需要f{i-1,m-1}次，找到子问题；
不碎的话，上面还有n-i层，还需要f[n-i,m]次，又一个子问题。 
状态转移方程如下： f{n, m} = min(1 + max(f{n - 1, m - 1}, f{n - i, m}) ) 其中： i为(1, n), f{i, 1} = 1
