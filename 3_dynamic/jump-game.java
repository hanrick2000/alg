// version 1: Dynamic Programming, 复杂度是 O(n^2) 可能会超时，但是依然需要掌握。
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
          return false;
        }
        boolean[] f = new boolean[A.length]; //f[i]表示能否从[0]跳到第i个位置
        f[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && j + A[j] >= i) {
                    f[i] = true; //跟jump game ii这里有区别, 后者是找出最小的跳跃步数
                    break;
                }
            }
        }
        return f[A.length - 1];
    }
}

// version 2: Greedy, 显然是O(n)
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
          return false;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && A[i] + i >= farthest) { //先判断上一跳后能否到达i位置, 然后再看当前一跳能否更新最远距离
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }
}

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
This problem have two method which is Greedy and Dynamic Programming.
The time complexity of Greedy method is O(n).
The time complexity of Dynamic Programming method is O(n^2).
We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
Example
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
*/
