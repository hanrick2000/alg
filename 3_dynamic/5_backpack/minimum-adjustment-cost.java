//好理解, 从这个出发, 再优化
public class Solution {
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if(A == null || A.size() == 0){
            return 0;
        }
        int n = A.size();
        int[][] f = new int[n + 1][100 + 1]; //f[i][j]表示前i个数, 第i个数调整成j, 满足相邻的数相差<=target, 所需要的最小代价
        for(int i = 1; i <= 100; i++){
            f[1][i] = Math.abs(A.get(0) - i);
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= 100; j++){
                f[i][j] = Integer.MAX_VALUE;
                if(f[i - 1][j] == Integer.MAX_VALUE){
                    continue;
                }
                for(int k = 1; k <= 100; k++){ //要枚举第i-1个数的各种情况
                    if (Math.abs(j - k) <= target) { //当前i位置的数字调整到j, j要与k的距离小于target, 调整过去的代价就是下面的abs(A.get(i-1)-j)
                        f[i][j] = Math.min(f[i][j], f[i - 1][k] + Math.abs(A.get(i - 1) - j));
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 100; i++){
            min = Math.min(min, f[n][i]);
        }
        return min;
    }
}

//唯一区别就是j从0开始, 题目要求是positive, 所以从上面代码是从1开始
public class Solution {
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if(A == null || A.size() == 0){
            return 0;
        }
        int n = A.size();
        int[][] f = new int[n + 1][100 + 1]; //f[i][j]表示前i个数, 第i个数调整成j, 满足相邻的数相差<=target, 所需要的最小代价
        for(int i = 0; i <= 100; i++){
            f[1][i] = Math.abs(A.get(0) - i);
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 100; j++){

                f[i][j] = Integer.MAX_VALUE;
                if(f[i - 1][j] == Integer.MAX_VALUE){
                    continue;
                }

                for(int k = 0; k <= 100; k++){ //要枚举第i-1个数的各种情况
                    if (Math.abs(j - k) <= target) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][k] + Math.abs(A.get(i - 1) - j));
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 100; i++){
            min = Math.min(min, f[n][i]);
        }

        return min;
    }
}


public class Solution {
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int n = A.size();
        // state
        int[][] f = new int[n + 1][100 + 1];
        // init
        for (int i = 0; i <= n ; ++i) {
            for (int j = 0; j <=100; ++j) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <= 100; ++i) { // 第0个数变成i的调整消耗
            f[0][i] = 0;
        }
        // function
        for (int i = 1; i <= n; ++i) {
            for (int  j = 0; j <= 100; ++j) {
                if (f[i - 1][j] != Integer.MAX_VALUE) { //做了一个剪枝, 第i-1个数如果不可能取j(因为i-1个数要满足与i-2个数满足差<=target的限制), 就跳过
                    for (int k = 0; k <= 100; ++k){
                        if (Math.abs(j - k) <= target) {
                            if (f[i][k] > f[i - 1][j] + Math.abs(A.get(i - 1) - k)) { //f[i][j] = min(f[i-1][v'] + |A[i] - v|), |v - v'| <= target 
                                f[i][k] = f[i - 1][j] + Math.abs(A.get(i - 1) - k);  
                            }
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; ++i) {
            if (f[n][i] < ans) {
                ans = f[n][i];
            }
        }
        return ans; 
    }
}

/*
Given an integer array, adjust each integers so that 
the difference of every adjacent integers are not greater than a given number target.
If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
You can assume each number in the array is a positive integer and not greater than 100.
Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
Return 2.
*/
