/*
Given a target number and an integer array A sorted in ascending order, 
find the index i in A such that A[i] is closest to the given target.
Return -1 if there is no element in the array.
There can be duplicate elements in the array, and we can return any of the indices with same value.
Given [1, 2, 3] and target = 2, return 1.
Given [1, 4, 6] and target = 3, return 1.
Given [1, 4, 6] and target = 5, return 1 or 2.
Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
*/

public class Solution {
  public int closestNumber(int[] A, int target) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int index = firstIndex(A, target);
    if (index == 0) {
      return 0;
    }
    if (index == A.length) {
      return A.length - 1;
    }
    if (target - A[index - 1] < A[index] - target) {
      return index - 1;
    }
    return index;
  }
  /*
   * 类似1-search-insert-position.java
   */
  private int firstIndex(int[] A, int target) {
    int start = 0, end = A.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] < target) {
        start = mid;
      } else if (A[mid] > target) {
        end = mid;
      } else {
        end = mid;
      }
    }
    //剩下两个值, 则有三个分段: target<=A[start], target<=A[end], target>A[end]
    //前两个分段时, 返回start或end, 最终取start-1, start, end-1, end之中
    //最后一个分段时, 只可能是target超出了array范围, 返回A.length
    // 处理target在start左侧情况, 最终结果是start-1, start二者之一
    if (A[start] >= target) {
      return start;
    }
    //这里是处理target在(start, end]之间的情况, 最终的结果在start和end二者之一
    if (A[end] >= target) {
      return end;
    }
    //到这里时, end一定等于A.length-1
    return A.length;
  }
}


/*
public class Solution {
  public int closestNumber(int[] A, int target) {
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
      } else if (mid - 1 >= 0 && A[mid - 1] <= target && target < A[mid]) {
        // 这两个条件可以帮助提前结束搜索, 在start和end还不满足退出循环时
        return (target - A[mid - 1]) < (A[mid] - target) ? (mid - 1) : mid; 
      } else if (mid + 1 < A.length && A[mid] < target && target <= A[mid + 1]) {
        return (target - A[mid]) < (A[mid + 1] - target) ? mid : mid + 1;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return (target - A[start]) < (A[end] - target) ? start : end;
  }
}
*/
