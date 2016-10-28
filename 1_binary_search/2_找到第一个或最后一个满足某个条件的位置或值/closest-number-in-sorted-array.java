public class Solution {
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int index = firstIndex(A, target); //index是A中第一个大于target的数的下标
        if (index == 0) {
            return 0;
        }
        if (index == A.length) {
            return A.length - 1;
        }
        if (target - A[index - 1] < A[index] - target) {//比较index和index-1与target哪个距离更近
            return index - 1;
        } else {
            return index;
        }
    }
    private int firstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }
        //剩下两个值, 则有三个分段: ^ A[start] ^ A[end] ^ 
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
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

