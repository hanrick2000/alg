//统一都用A[end]作为判断哪边有序的标志
public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            } else if (A[mid] == A[end]) {
                end--;
            } else if (A[mid] < A[end]) {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (A[mid] > A[end]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (A[start] == target) {
            return true;
        }
        if (A[end] == target) {
            return true;
        }
        return false;
    }
}

当用A[end]作为标志时, 如果不对A[mid]==A[end]时做end--, 那么[3 1 2 2 2]就是一个bad case
第一刀mid在中间的2, 发现A[mid] < A[end]不成立, 会以为mid左侧是有序的, 但实则不然[3 1 2]




public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == A[start]) {
                start++; //****************  最坏case [1 1 1 1 1 1 0], 考虑5 5 5 5 6 2
            } else if (A[mid] == target) { 
                return true;
            } else if (A[mid] > A[start]) { //说明start到mid之间有序
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { //说明mid 到 end之间有序
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return true;
        }
        if (A[end] == target) {
            return true;
        }
        return false;
    }
}

2 2 2 3 1




/*
Follow up for Search in Rotated Sorted Array:
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
Given [1, 1, 1, 1, 1, 1] and target = 0, return false.
*/
public class Solution {
  // 这个问题在面试中不会让实现完整程序
  // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
  // 在这种情况下是无法使用二分法的，复杂度是O(n)
  // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
  //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
  //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
  public boolean search(int[] A, int target) {
    for (int i = 0; i < A.length; i ++) {
      if (A[i] == target) {
        return true;
      }
    }
    return false;
  }
}
