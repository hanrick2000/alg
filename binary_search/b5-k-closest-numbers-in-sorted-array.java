/*
Given a target number, a non-negative integer k and an integer array A sorted in ascending order, 
find the k closest numbers to target in A, 
sorted in ascending order by the difference between the number and target. 
Otherwise, sorted in ascending order by number if the difference is same.

Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
*/
public class Solution {
  /**
   * @param A an integer array
   * @param target an integer
   * @param k a non-negative integer
   * @return an integer array
   */
  public int[] kClosestNumbers(int[] A, int target, int k) {
    int[] result = new int[k];
    
    if (A == null || A.length == 0) {
      return A;
    }
    if (k > A.length) {
      return A;
    }
    
    // 若     target<=A[start], 返回start
    // 否则,若target<=A[end] , 返回end
    // 否则:  target> A[end], 返回A.length
    // 这样firstIndex返回的是target所在区间(start, end)的end值
    int index = firstIndex(A, target);
    
    // 所以start才是index-1
    int start = index - 1;
    int end = index;
    // 这里的start和end应该叫做left和right指针更贴切, 分别指向target左边和右边的值
    for (int i = 0; i < k; i++) {
      if (start < 0) {
        // target在最左边情况, 要让end一直向右移动
        result[i] = A[end++];
      } else if (end >= A.length) {
        // taget在最右边情况, 让start一直向左移动
        result[i] = A[start--];
      } else {
        if (target - A[start] <= A[end] - target) {
          //如果A[start]更接近target, 则取A[start], 并将start左移
          result[i] = A[start--];
        } else {
          result[i] = A[end++];
        }
      }
    }
    return result;
  }
  
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
    
    if (A[start] >= target) {
      return start;
    }
    if (A[end] >= target) {
      return end;
    }
    return A.length;
  }
}
