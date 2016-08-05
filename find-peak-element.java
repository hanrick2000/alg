/*
   看mid，如果mid>mid-1，且 mid>mid+1，则返回mid
   最左边和最右边的元素都是最小的, 所以:
   mid < mid - 1, 则在mid左边区间搜索可以得到一个peak
   mid > mid + 1，则在mid右边区间搜索可以得到一个peak
   最后生两个数，返回高的就是peak
 */
class Solution {
  /**
   * @param A: An integers array.
   * @return: return any of peek positions.
   */
  public int findPeak(int[] A) {
    int start = 1; 
    int end = A.length-2; // 1.答案在[1,A.length-1]之间，2.不会出界 
    while(start + 1 <  end) {
      int mid = (start + end) / 2;
      if(A[mid] < A[mid - 1]) {
        end = mid;
      } else if(A[mid] < A[mid + 1]) {
        start = mid;
      } else {
        return mid;
      }
    }
    if(A[start] < A[end]) {
      return end;
    } else {
      return start;
    }
  }
}
