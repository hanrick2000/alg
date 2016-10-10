/*
Give an integer array，find the longest increasing continuous subsequence in this array.
An increasing continuous subsequence:
Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
O(n) time and O(1) extra space.
Have you met this question in a real interview? Yes
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.


引子题, 10-15分钟做完, 为了引出longest-increasing-continuous-subsequence-ii
*/
public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int answer = 1;
        // from left to right
        int length = 1; // just A[0] itself
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }
        // from right to left
        length = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }
        return answer;
    }
}
