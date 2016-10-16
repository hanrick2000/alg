/*
There are n coins in a line. 
Two players take turns to take a coin from one of the ends of the line until there are no more coins left.  从头或者尾取
The player with the larger amount of money wins.
Could you please decide the first player will win or lose?
Have you met this question in a real interview? Yes
Example
Given array A = [3,2,2], return true.
Given array A = [1,2,4], return true.
Given array A = [1,20,4], return false.
Challenge 
Follow Up Question:
If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?
*/

//区间+博弈+记忆话搜索

// 方法一
import java.util.*;
public class Solution {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int [][]dp = new int[n + 1][n + 1]; //还剩从第i到第j的硬币, 现在当前取硬币的人能得到的最大价值
        boolean [][]flag =new boolean[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1]; //从第i到第j的和
        for (int i = 0; i < n; i++) {
            sum[i][i] = values[i];
            for (int j = i; j < n; j++) {
                else sum[i][j] = sum[i][j-1] + values[j];
            }
        }
        int allsum = 0;
        for(int now : values) allsum += now;
        return allsum < 2 * MemorySearch(0, n-1, dp, flag, values, sum); //表示从第0到第n-1的硬币中取, 先手能获得的最大价值
    }
    int MemorySearch(int left, int right, int [][]dp, boolean [][]flag, int []values, int [][]sum) {
        if(flag[left][right])   
            return dp[left][right];
        flag[left][right] = true;  
        if(left > right) {
            dp[left][right] = 0;
        } else if (left == right) {
            dp[left][right] = values[left];
        } else if(left + 1 == right) {
            dp[left][right] = Math.max(values[left], values[right]);
        } else {
            int cur = Math.min(MemorySearch(left+1, right,   dp, flag, values, sum), 
                               MemorySearch(left,   right-1, dp, flag, values, sum));
            // 先手若是取了左边, 则后手能获得的最大价值就是MemorySearch(left+1, right, dp, flag, values, sum), 若先手取了右边, 则后手能得到的最大价值就是MemorySearch(left,right-1, dp, flag, values, sum)
            // 先手为了让自己多拿一些, 必然从上面的两种情况中选取后手获得最少的方式
            dp[left][right] = sum[left][right] - cur;
        }
        return dp[left][right];   
    }
}

// 方法二
import java.util.*;
public class Solution {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int [][]dp = new int[n + 1][n + 1];
        boolean [][]flag =new boolean[n + 1][n + 1];
        int sum = 0;
        for(int now : values) 
            sum += now;
        return sum < 2*MemorySearch(0, n-1, dp, flag, values);
    }
    int MemorySearch(int left, int right, int [][]dp, boolean [][]flag, int []values) {
        if(flag[left][right])   
            return dp[left][right];
        flag[left][right] = true;
        if(left > right) {
            dp[left][right] = 0;
        } else if (left == right) {
            dp[left][right] = values[left];
        } else if(left + 1 == right) {
            dp[left][right] = Math.max(values[left], values[right]);
        } else {
            int  pick_left = Math.min(MemorySearch(left + 2, right, dp, flag, values), MemorySearch(left + 1, right - 1, dp, flag, values)) + values[left];
                //如果先手取了左边, 后手肯定会留下小的      min(后手取左边                          后手取右边)
            int  pick_right = Math.min(MemorySearch(left, right - 2, dp, flag, values), MemorySearch(left + 1, right - 1, dp, flag, values)) + values[right];
                //如果先手取了右边, 后手肯定会留下小的      min(后手取左边                          后手取右边)
            dp[left][right] = Math.max(pick_left, pick_right);    
        }
        return dp[left][right];   
    }
}

//这么写是错误的, 因为dp[i][j]是依赖于dp[i+1][j]和dp[i][j-1], 这样的for循环是无法在此时知道dp[i+1][j]的, 所以还是要用记忆话搜索
public class Solution{
    public boolean firstWillWin(int[] values){
        int n = values.length;
        int[][] sum = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i==j) 
                     sum[i][j] = values[i];
                else 
                     sum[i][j] = sum[i][j-1] + values[j];
            }
        }
        int allsum = 0;
        for(int now: values) allsum += now;
        //state
        int[][] dp = new int[n][n]; //现在还剩从第i到第j的硬币, 现在当前取硬币的人最多获取的硬币价值
        //init
        for(int i=0; i<n; i++) 
            dp[i][i] = values[i];
        //function
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                dp[i][j] = sum[i][j] - Math.min(dp[i+1][j], dp[i][j-1]); // XXXXXXXXXXXXXXXXXXXXX
            }
        }
        //result
        return dp[0][n-1] > allsum/2;
    }
}


