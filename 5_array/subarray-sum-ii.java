public class Solution {
    public int subarraySumII(int[] A, int start, int end) {
        if(A == null || A.length == 0 || start > end){
            return 0;
        }
        int[] sum = new int[A.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= A.length; i++){
            sum[i] = sum[i - 1] + A[i - 1];
        }
        int count = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j <= A.length; j++){
                int diff = sum[j] - sum[i];
                if(diff >= start && diff <= end){
                    count++;
                }
            }
        }
        return count;
    }
}

/*
和I一样, 用prefix来解.
首先计算prefix, 然后根据prefix来计算每一段subarray的sum.
右边prefix - 左边prefix等于中间这一段subarray的sum.
左边prefix从0枚举到n－1, 右边prefix从当前左边往右一位开始枚举到n,
这样可以得到所有sunarray的sum，每一个sum如果在interval之内则count增加1个.
O(n^2).

Given an integer array, 
find a subarray where the sum of numbers is in a given interval. 
Your code should return the number of possible answers. 
(The element in the array should be positive)
Example
Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:
[0, 0]
[0, 1]
[1, 1]
[2, 2]
Tags: Two Pointers Array
*/
