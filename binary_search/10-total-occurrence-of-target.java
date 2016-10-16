/*
Given a target number and an integer array sorted in ascending order. 
Find the total number of occurrences of target in the array.
Given [1, 3, 3, 4, 5] and target = 3, return 2.
Given [2, 2, 3, 4, 6] and target = 4, return 1.
Given [1, 2, 3, 4, 5] and target = 6, return 0.

跟search-for-a-range很像
先找左边界, 再找右边界
*/
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
  public int totalOccurrence(int[] A, int target) {
    // Write your code here
    int n = A.length;
    if (n == 0)
      return 0;
    if (A[n-1] < target || A[0] > target)
      return 0;
    
    int start, end, mid;
    int[] bound = new int[2];

    // search for left bound
    start = 0;
    end = A.length - 1;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] == target) {
        end = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (A[start] == target) {
      bound[0] = start;
    } else if (A[end] == target) {
      bound[0] = end;
    } else {
      return 0;
    }

    // search for right bound
    start = 0;
    end = A.length - 1;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] == target) {
        start = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (A[end] == target) {
      bound[1] = end;
    } else if (A[start] == target) {
      bound[1] = start;
    } else {
      return 0;
    }
    return bound[1] - bound[0] + 1;
  }
}
