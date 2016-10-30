public class Solution {
    public int postOffice(int[] A, int k) {
        if(A == null || A.length == 0 || k <= 0 || k >= A.length){
            return 0;
        }
        //一个Array只有单调才满足中间的数和其它所有数的差的绝对值之和最小
        Arrays.sort(A);
        int n = A.length;
        //dis[i][j]: the distance sum if build post in the mid of the i,j
        int[][] dis = initial(A);
        //dp[i][l]: 前i个house建l个post的最小距离
        int[][] dp = new int[n + 1][k + 1];
        //只建一个post情况，在中间建距离之和最小
        for(int i = 0; i <= n; i++){
            dp[i][1] = dis[1][i];
        }
        for(int l = 2; l <= k; l++){
            for(int i = l; i <= n; i++){
                dp[i][l] = Integer.MAX_VALUE;
                //j为分割点，从l-1到i-1(因为l－1个post至少需要l－1个house)
                for(int j = l - 1; j < i; j++){
                    dp[i][l] = Math.min(dp[i][l], dp[j][l - 1] + dis[j + 1][i]);
                }
            }
        }
        return dp[n][k];
    }
    private int[][] initial(int[] A){
        int n = A.length;
        int[][] dis = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){
                int mid = (i + j) / 2;
                for(int k = i; k <= j; k++){
                    //所有点到mid的距离
                    dis[i][j] += Math.abs(A[k - 1] - A[mid - 1]);
                }
            }
        }
        return dis;
    } 
}

状态函数：
dp[i][l]＝dp[j][l-1] + dis[j+1][i] (l-1<=j<i)。
其中dp[i][l]表示在前i个村庄中建l个post的最短距离，j为分隔点，可以将问题转化为在前j个村庄建l－1个post的最短距离＋在第j＋1到第i个村庄建1个post的最短距离。其中有个性质，如元素是单调排列的，则在中间位置到各个元素的距离和最小。
初始化dis矩阵，枚举不同开头和结尾的村庄之间建1个post的最小距离，即求出开头和结尾村庄的中间点，然后计算开头到结尾的所有点到中间点的距离。记得要对原矩阵排序，这样才能用中间点距离最小性质。
初始化dp矩阵，即初始化dp[i][1]，求前i个村庄建1个post的最小距离（可根据dis求出）。
post数l从2枚举到k，开始村庄i从l枚举到结尾（因为要建l个post至少需要l个村庄，否则没有意义），然后根据状态函数求dp[i][l]，分割点j从l－1枚举到i-1（前j个村庄建l－1个post则至少需要l－1个村庄），在这些分隔点的情况下求dp[i][l]的最小值。
4.返回dp[n][k]即可。

On one line there are n houses. 
Give you an array of integer means the the position of each house. 
Now you need to pick k position to build k post office, 
so that the sum distance of each house to the nearest post office is the smallest. 
Return the least possible sum of all distances between each village and its nearest post office.

Example
Given array a = [1,2,3,4,5], k = 2.
return 3.

Challenge 
Could you solve this problem in O(n^2) time ?
