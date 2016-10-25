/*
Given n pieces of wood with length L[i] (integer array). 
Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
What is the longest length you can get from the n pieces of wood? 
Given L & k, return the maximum length of the small pieces.
You couldn't cut wood into float length.
For L=[232, 124, 456], k=7, return 114.
O(n log Len), where Len is the longest length of the wood.
*/
public class Solution {
  /** 
   *@param L: Given n pieces of wood with length L[i]
   *@param k: An integer
   *return: The maximum length of the small pieces.
   */
  public int woodCut(int[] L, int k) {
    int max = 0;
    for (int i = 0; i < L.length; i++) {
      max = Math.max(max, L[i]);
    }
    
    // find the largest length that can cut more than k pieces of wood.
    int start = 1, end = max;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (count(L, mid) >= k) {
        start = mid;
      } else {
        end = mid;
      }
    }
    
    //先判断end, 因为越长越好
    if (count(L, end) >= k) {
      return end;
    }
    if (count(L, start) >= k) {
      return start;
    }
    return 0;
  }
  
  // 用于检查当前的木头长度能够cut几块木头
  private int count(int[] L, int length) {
    int sum = 0;
    for (int i = 0; i < L.length; i++) {
      sum += L[i] / length;
    }
    return sum;
  }
}
