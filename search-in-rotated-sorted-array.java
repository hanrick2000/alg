/*
 mid左右必有一个是有序的
 如果 A[start] < A[mid], 则说明mid左侧是有序的, eg 4 5 6 7 [8] 0 1 2 3
 如果 A[start] > A[mid], 则说明mid右侧是有序的, eg 7 8 0 1 [2] 3 4 5 6
 知道哪边是有序的, 则可以看看target在不在有序的那边
   根据target在不在有序的那边, 确定后续搜索的范围(即如何更新start, end)
 */
public class Solution {
  public int search(int[] A, int target) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int start = 0;
    int end = A.length - 1;
    int mid;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] == target) {
        return mid;
      }
      if (A[start] < A[mid]) {
        // situation 1, red line
        if (A[start] <= target && target <= A[mid]) {
          end = mid;
        } else {
          start = mid;
        }
      } else {
        // situation 2, green line
        if (A[mid] <= target && target <= A[end]) {
          start = mid;
        } else {
          end = mid;
        }
      }
    } // while
    if (A[start] == target) {
      return start;
    }
    if (A[end] == target) {
      return end;
    }
    return -1;
  }
}
