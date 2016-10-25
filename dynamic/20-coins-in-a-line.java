// me
public class Solution { //直接前向dp
    public boolean firstWillWin(int n){
        if(n==0){
            return false;
        }else if(n==1){ 
            return true;
        }else if(n==2){
            return true;
        }
        boolean[] f = new boolean[n+1]; //f[i]表示剩下i个硬币时, 先手能否赢
        f[0] = false;
        f[1] = true;
        f[2] = true;
        for (int index = 3; index <= n; index++) {
            f[index] = !f[index - 1] || !f[index-2];
        }
        return f[n];
    }
}

public class Solution { // lintcode上这个会栈溢出
    public boolean firstWillWin(int n) {
        boolean []dp = new boolean[n+1]; //f[i]表示剩下i个硬币时, 先手能否赢
        boolean []flag = new boolean[n+1];
        return MemorySearch(n, dp, flag);
    }
    boolean MemorySearch(int i, boolean []dp, boolean []flag) {
        if(flag[i] == true) {
            return dp[i];
        }
        if(i == 0) { //一个都不剩, 说明拿不到最后一个, 所以是false
            dp[i] = false;
        } else if(i == 1) {
            dp[i] = true;
        } else if(i == 2) {
            dp[i] = true;
        } else {
            dp[i] = !MemorySearch(i-1, dp, flag) || !MemorySearch(i-2, dp, flag);
        }
        flag[i] =true;
        return dp[i];
    }
}

public class Solution { // lintcode不会栈溢出, 实际上就是把栈搜索的深度变小了, 从小规模问题开始算, 然后用dp存起来, 大问题实际上不用递归了, 直接返回了结果, 所以栈不会深.
    public boolean firstWillWin(int n) {
        boolean []dp = new boolean[n+1];
        boolean []flag = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            memorySearch(i, dp, flag);
        }
        return dp[n];
    }
    boolean memorySearch(int i, boolean []dp, boolean []flag) {
        if(flag[i] == true) {
            return dp[i];
        }
        if(i == 0) {
            dp[i] = false;
        } else if(i == 1) {
            dp[i] = true;
        } else if(i == 2) {
            dp[i] = true;
        } else {
            dp[i] = !memorySearch(i-1, dp, flag) || !memorySearch(i-2, dp, flag);
        }
        flag[i] =true;
        return dp[i];
    }
}

/*
第二个思路solution用0 1 2 这样的flag代替了flag[]数组 同时
if((MemorySearch(n-2, dp) && MemorySearch(n-3, dp)) || 
                (MemorySearch(n-3, dp) && MemorySearch(n-4, dp) ))
这样下一次递归n的值变成了n-2, n-4, n-6…这样调用次数就变成了一半。你试试调用第二个solution 用大一点的n，比如30000， 同样会产生StackOverflowError
*/
public class Solution {
    public boolean firstWillWin(int n) {
        int []dp = new int[n+1];
        return MemorySearch(n, dp);
    }
    boolean MemorySearch(int n, int []dp) { // 0 is empty, 1 is false, 2 is true
        if(dp[n] != 0) {
            if(dp[n] == 1) return false;
            else return true;
        }
        if(n <= 0) {
            dp[n] = 1; //false
        } else if(n == 1) {
            dp[n] = 2; //true
        } else if(n == 2) {
            dp[n] = 2; //true
        } else if(n == 3) {
            dp[n] = 1; //false
        } else {
            if((MemorySearch(n-2, dp) && MemorySearch(n-3, dp)) || 
                (MemorySearch(n-3, dp) && MemorySearch(n-4, dp) )) {
                dp[n] = 2; //true
            } else {
                dp[n] = 1; //false
            }
        }
        if(dp[n] == 2) 
            return true;
        return false;
    }
}

/*
There are n coins in a line. Two players take turns to take one or two coins 
from right side until there are no more coins left. 
The player who take the last coin wins.
Could you please decide the first play will win or lose?
Example
n = 1, return true.
n = 2, return true.
n = 3, return false.
n = 4, return true.
n = 5, return true.
Challenge 
O(n) time and O(1) memory
*/

//最简单, n%3!=0, 先手赢 . . (. . .)
