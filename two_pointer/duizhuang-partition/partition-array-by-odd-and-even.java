public class Solution {
    public void partitionArray(int[] nums) {
        int start = 0; 
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) { //如果是奇数继续找, 直到找到偶数
                start++;
            }
            while (start < end && nums[end] % 2 == 0) { //如果是偶数就继续找, 知道找到奇数
                end--;
            }
            if (start < end) {
                int temp = nums[start];  //交换奇偶位置
                nums[start] = nums[end]; 
                nums[end] = temp;
                start++;
                end--;
            } 
        }
    }
}

Partition an integers array into odd number first and even number second.
Given [1, 2, 3, 4], return [1, 3, 2, 4]
Do it in-place.

