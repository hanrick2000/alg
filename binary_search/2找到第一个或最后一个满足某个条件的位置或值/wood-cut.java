//劈木头, 最少k根, 每根最长是多少
public class Solution {
    public int woodCut(int[] L, int k) {
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        int start = 1
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (count(L, end) >= k) { //剩下start和end, 要
            return end;
        }
        if (count(L, start) >= k) {
            return start;
        }
        return 0;
    }
    private int count(int[] L, int length) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / length;
        }
        return sum;
    }
}

start end mid count
1     456 228 <7
1     228 114 >=7
114   228 171 <7
114   171 142 <7
114   142 128 <7
114   128 121 <7
114   121 117 <7
114   117 115 <7
114   115 break
start = 114
end = 115
最后要测试114和115那个满足条件

/*
Given n pieces of wood with length L[i] (integer array). 
Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
What is the longest length you can get from the n pieces of wood? 
Given L & k, return the maximum length of the small pieces.
You couldn't cut wood into float length.
For L=[232, 124, 456], k=7, return 114.
O(n log Len), where Len is the longest length of the wood.
*/
