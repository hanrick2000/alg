public class Solution {
    public int searchInsert(int[] ary, int target) { //寻找大于target的最小值的位置
        if (ary == null || ary.length == 0){
            return 0;
        }
        int start = 0;
        int end = ary.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (ary[mid] == target) {
                end = mid; //因为没有重复, 所以可以直接return, 为了统一
            } else if (ary[mid] < target) {
                start = mid;
            } else if (ary[mid] > target) {
                end = mid;
            }
        }
        if (ary[start] >= target) {        // ^ ary[start] ^ ary[end] ^, 这三个^位置是候选插入位置
            return start;
        } else if (ary[end] >= target) {
            return end;
        } else {
            return end + 1; // return ary.length 也行
        }
    }
}

/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume NO duplicates in the array.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
/*
binary search要点: 
start+1 < end
start + (end-start) / 2
ary[mid] ==, >, <
ary[start] A[end] ? target

基本就是标准的binary search
注意最后的end+1
注意这是个没有重复的ary

这个解法是找the first position >= target
最后时刻只有2个：start, end
这样就有3个位置

<= start
<= end
> end

分别判断即可
*/
