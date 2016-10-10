/*
There is a stone game.At the beginning of the game the player picks n piles of stones in a line.
The goal is to merge the stones in one pile observing the following rules:
At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.
For [4, 1, 1, 4], in the best solution, the total score is 18:
1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43
合并石子, 得到最小价值
*/
//记忆化
public class Solution {
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        // state
        int[][] f = new int[n][n]; //把第i个到第j个石子合并在一起的最小花费
        // initialize
        for (int i = 0; i < n; i++) {
            f[i][i] = 0; //f[0][0], f[1][1]...都是0, 因为不需要合并
        }
        // preparation
        int[][] sum = new int[n][n]; //sum[l][r]表示从l到r的和
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }
        int[][] visit = new int[n][n];
        return search(0, n-1, f, visit, sum);
    }
    int search(int l, int r, int[][] f, int[][] visit, int[][] sum) {
        if(visit[l][r] == 1)
            return f[l][r];
        if(l == r) {
            visit[l][r] = 1;
            return f[l][r]; //因为已经初始化过
        }
        f[l][r] = Integer.MAX_VALUE; //因为是要找最小值, 先初始成最大
        for (int k = l; k < r; k++) {
            f[l][r] = Math.min(f[l][r], 
                               search(l, k, f, visit, sum) + search(k + 1, r, f, visit, sum) + sum[l][r]); //把l到r在k处切开, 分成的两堆, 合并时的消耗
        }
        visit[l][r] = 1;
        return f[l][r];
    }
}


// for 循环
public class Solution {
    public int stoneGame(int[] A) {
        // Write your code here
        if(A.length==0) {
            return 0;
        }
        int[][] dp=new int[A.length][A.length];
        int[] sums=new int[A.length+1];
        sums[0]=0;
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<A.length;i++){
            dp[i][i]=0;
            sums[i+1]=sums[i]+A[i];
        }
        return search(0,A.length-1,dp,sums);
    }
    private int search(int start, int end, int[][] dp, int[] sums){
        if(dp[start][end]!=Integer.MAX_VALUE){
            return dp[start][end];
        }
        int min=Integer.MAX_VALUE;
        for(int k=start;k<end;k++){
            int left = search(start,k,dp,sums);
            int right = search(k+1,end,dp,sums);
            int now = sums[end+1]-sums[start];
            min=Math.min(min,left+right+now);
        }
        dp[start][end]=min;
        return min;
    }
}
