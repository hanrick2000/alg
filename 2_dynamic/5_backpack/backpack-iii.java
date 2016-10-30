public class Solution{
    public int backPackIII(int[] A, int[] V, int m){
        //state
        int[][] f = new int[A.length + 1][m + 1]; //前i个物体放入容量是j的包中, 最大能放多少价值
        //init
        for(int i = 0; i <= m; i++){
            f[0][i] = 0;
        }
        for(int i = 0; i <= A.length; i++){
            f[i][0] = 0;
        }
        //fuction
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = f[i - 1][j];
                if(j >= A[i - 1]){//notice: A[i-1]
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - A[i - 1]] + V[i - 1]); //唯一要改的地方
                }   //                                ^  前i个
            }
        }
        //result
        return f[A.length][m];
    }
}

public class Solution {
    public int backPackIII(int[] A, int[] V, int m) {
        int[] f = new int[m+1];        
        for (int i = 0; i <=m ; ++i) f[i] = 0;
        int n = A.length, i, j;
        for (i = 0; i < n; ++i)
            for (j = m; j >= A[i]; j--)
                if (f[j] < f[j -A[i]] + V[i])
                    f[j] = f[j - A[i]] + V[i];
        return f[m];
    }
}

/*
Given n kind of items with size Ai and value Vi( each item has an infinite number available) 
and a backpack with size m. 
What's the maximum value can you put into the backpack?
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], 
and a backpack with size 10. The maximum value is 15.
*/
