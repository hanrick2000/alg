public class Solution {
    public int maxSubArray(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int n = A.length;
        // state
        int[] f = new int[n + 1]; //f[i]表示前i个元素, 且以第i个元素为结尾的最大和是多少
        // init
        int max = Integer.MIN_VALUE;
        f[0] = 0;
        // function
        for(int i = 1; i <= n; i++) {
            f[i] = Math.max(A[i - 1], f[i - 1] + A[i - 1]);
            if(f[i] > max){
                max = f[i];
            }
        }
        // result
        return max;
    }
}

//Prefix sum
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int preSum = 0; //从0到当前遍历位置的所有和
        int minSum = 0; //从0到当前遍历位置的最小和
        for (int i = 0; i < A.length; i++) {
            preSum += A[i];
            max = Math.max(max, preSum - minSum);
            minSum = Math.min(minSum, preSum);
        }
        return max;
    }
}

// Greedy
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}


public class Solution {
    public int maxSubArray(ArrayList<Integer> nums) {
        if(nums.size()==0){  
            return 0;  
        }
        int n = nums.size();
        int[] global = new int[n];
        int[] local = new int[n];
        global[0] = nums.get(0);
        local[0] = nums.get(0);
        for(int i = 1; i < n; i++)  
        {
            local[i] = Math.max(nums.get(i), local[i - 1] + nums.get(i));  
            global[i] = Math.max(local[i], global[i - 1]);  
        }
        return global[n-1];  
    }
}

/*
Given an array of integers, 
find a contiguous subarray which has the largest sum.
The subarray should contain at least one number.
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], 
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
Challenge 
Can you do it in time complexity O(n)?
*/
