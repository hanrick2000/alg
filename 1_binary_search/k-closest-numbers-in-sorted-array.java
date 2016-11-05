public class Solution {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];
        if (A == null || A.length == 0) {
            return A;
        }
        if (k > A.length) {
            return A;
        }
        int index = firstIndex(A, target); //index是A中第一个大于target的数的下标
        int start = index - 1; // start相当于第一个小于target的数的下标
        int end = index; // end则是第一个大于target的数的下标 
        // 这里的start和end应该叫做left和right指针更贴切, 分别指向target左边和右边的值
        for (int i = 0; i < k; i++) {
            if (start < 0) { // 已经取到了最左边的值, 要让end一直向右移动
                result[i] = A[end];
                end++;
            } else if (end >= A.length) { // 已经取到了最右边的值, 让start一直向左移动
                result[i] = A[start];
                start--;
            } else {
                if (target - A[start] <= A[end] - target) { //如果A[start]更接近target, 则取A[start], 并将start左移
                    result[i] = A[start];
                    start--;
                } else { // target -A[start] > A[end] - target, 表示A[end]更接近target, 则收录A[end], end右移
                    result[i] = A[end];
                    end++;
                }
            }
        }
        return result;
    }
    private int firstIndex(int[] A, int target) { //返回大于target的最小值
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
Given a target number, a non-negative integer k and an integer array A sorted in ascending order, 
find the k closest numbers to target in A, 
sorted in ascending order by the difference between the number and target. 
Otherwise, sorted in ascending order by number if the difference is same.

Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
*/
