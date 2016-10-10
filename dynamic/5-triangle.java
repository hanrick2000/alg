/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
Example
Given the following triangle:
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

// DFS Traverse, run out of time, also have duplicated computation, eg: 5 from both 3 and 4
public class Solution {
    private int result;
    private int[][] triangle;
    private int n;
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0) return -1;
        if(triangle[0] == null || triangle[0].length == 0) return -1;
        this.result = Integer.MAX_VALUE;
        this.n = triangle.length;
        this.triangle = triangle;
        dfs(0,0,0);
        return result;
    }
    public void dfs(int x, int y, int sum){
        if(x == this.n){
            if(sum < this.result){
                this.result = sum;
            }
            return; // careful, we should return here
        }
        dfs(x+1, y, sum + this.triangle[x][y]);
        dfs(x+1, y+1, sum + this.triangle[x][y]);
    }
}

// DFS Divide conquer, run out of time, also have dulicated computation
public class Solution{
    private int[][] triangle;
    private int n;
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0 ) return -1;
        if(triangle[0] == null || triangle[0].length == 0) return -1;
        this.triangle = triangle;
        this.n = triangle.length;
        return divideconquer(0,0);
    }
    public int divideconquer(int x, int y){
        // return the minimum path from(x,y) to bottom
        if(x == this.n){
            return 0;
        }
        return this.triangle[x][y] + Math.min(divideconquer(x+1, y), 
                                              divideconquer(x+1, y+1));
    }
}

// DFS Divide conquer with hash, can pass time limit.
public class Solution{
    private int[][] triangle;
    private int n;
    private int[][] hashmap;
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0 ) return -1;
        if(triangle[0] == null || triangle[0].length == 0) return -1;
        this.triangle = triangle;
        this.n = triangle.length;
        this.hashmap = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                this.hashmap[i][j] = Integer.MAX_VALUE;
            }
        }
        return divideconquer(0,0);
    }
    public int divideconquer(int x, int y){
        // return the minimum path from(x,y) to bottom
        if(x == this.n){
            return 0;
        }
        if(this.hashmap[x][y] < Integer.MAX_VALUE) return this.hashmap[x][y];
        
        this.hashmap[x][y] = triangle[x][y] + Math.min(divideconquer(x+1, y), 
                                                       divideconquer(x+1, y+1));
        return this.hashmap[x][y];
    }
}

//Version 1: dp, Bottom-Up
public class Solution {
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        // initialize 
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }
        
        // bottom up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }
        
        // answer
        return f[0][0];
    }
}


//Version 2 : Memorize Search, actually is divide conquer with hashmap
public class Solution {
    private int n;
    private int[][] minSum;
    private int[][] triangle;

    private int search(int x, int y) {
        if (x >= n) {
            return 0;
        }

        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }

        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1))
            + triangle[x][y];
        return minSum[x][y];
    }

    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return search(0, 0);
    }
} 

//dynamic programming, top-down, 最一般方法
public class Solution {
    public int minimumTotal(int[][] triangle) {
        //边界检测
        if (triangle == null || triangle.length == 0) return -1;
        if (triangle[0] == null || triangle[0].length == 0) return -1;
        //state
        int n = triangle.length;
        int[][] f = new int[n][n];// state: f[x][y] = minimum path value from 0,0 to x,y
        //init
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {//初始化三角形的左右边
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }
        //fuction
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }
        //result
        int best = f[n - 1][0];//获取最后一行的最小值
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }
}

//dp, top-down, with space O(n), 我的版本, 滚动数组(这个麻烦, %2的容易)
public class Solution {
    public int minimumTotal(int[][] triangle) {
        //边界检测
        if (triangle == null || triangle.length == 0) return 0;
        //state
        int[] last = new int[triangle.length]; //last[j]表示从root到上一层j位置的最短路径
        int[] current = new int[triangle.length]; //current[j]表示从root到当前层j位置的最小路径
        //init
        last[0] = triangle[0][0];
        current[0] = last[0];
        //fuction
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                int j_min_path = Integer.MAX_VALUE;
                int left_path = Integer.MAX_VALUE;
                int right_path = Integer.MAX_VALUE;
                if (j != 0) {//如果不是第i层的最左边
                    left_path = triangle[i][j] + last[j - 1];
                }
                if (j != i) {//如果不是第i层的最右边
                    right_path = triangle[i][j] + last[j];
                }
                j_min_path = Math.min(left_path, right_path);
                current[j] = j_min_path;
            }
            for (int k = 0; k < i + 1; k++) last[k] = current[k];
        }
        //result
        int min = Integer.MAX_VALUE;
        for (int n : current) {
            min = Math.min(n, min);
        }
        return min;
    }
}

//dp, top-down, with space O(n)
public class Solution {
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) return 0;
        int[] last = new int[triangle.length];  //last[j]表示从root到上一层j位置的最短路径
        int[] current = new int[triangle.length]; //current[j]表示从root到当前层j位置的最小路径
        last[0] = triangle[0][0];
        current[0] = last[0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                int sum = Integer.MAX_VALUE;
                if (j != 0) { //非i层的最左边
                    sum = triangle[i][j] + last[j - 1];
                }
                if (j != i) { //非i层的最右边
                    sum = Math.min(sum, triangle[i][j] + last[j]);
                }
                current[j] = sum;
            }
            for (int k = 0; k < i + 1; k++) last[k] = current[k];
        }
        int min = Integer.MAX_VALUE;
        for (int n : current) {
            min = Math.min(n, min);
        }
        return min;
    }
}

/*
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
从第二行开始
比如3, j=0是最左边的, 则sum是当前的3+上一行的j位置last[j]
因为是最左边的, 只有一个可以到达的路径, current[j]就是sum
到4, j=1是最右边的, sum则是4+上一行j-1位置last[j-1]
因为是最右边, 也只有一个可以到达的路径, current[j]就是sum
第三行的6和7同理, 对于5, 因其不是最左边的, 先看看5+last[j-1]的值, 然后因为他也不是最右边的, 则last[j]存在的, 再看看5+last[j], 从这里面选出一个最小的作为current[j]的值, 表示从root到当前行j位置的最短路径

*/
