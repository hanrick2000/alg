public class Solution{
    public int backPack(int m, int[] A){
        //state
        int f[][] = new int[A.length + 1][m + 1]; //f[i][j]前i个物体放入容量是j的包中, 最大能放多少体积
        //init
        for(int i = 0; i <= m; i++){
            f[0][i] = 0;
        }
        for(int i = 0; i <= A.length; i++) {
            f[i][0] = 0;
        }
        //fuction
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = f[i - 1][j];
                if(j >= A[i - 1]){//notice: A[i-1]
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - A[i - 1]] + A[i - 1]);
                    //                 不放第i个物品,  放第i个物品
                }
            }
        }
        //result
        return f[A.length][m];
    }
}


public class Solution {
    public int backPack(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= A[i] && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
            } // for j
        } // for i
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
}

/*
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
You can not divide any item into small pieces.
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, 
we can select [2, 3, 5], so that the max size we can fill this backpack is 10. 
If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
You function should return the max size we can fill in the given backpack.
Challenge 
O(nm) time and O(m) memory.
O(nm) memory is also acceptable if you do not know how to optimize memory.
*/
