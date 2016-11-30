public class Solution {
    public void partitionArray(int[] nums){
        if(nums ==  null || nums.length == 0){
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] % 2 == 0){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] % 2 == 1){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
    }
}

/*
左边是奇数, 右边是偶数
Partition an integers array into odd number first and even number second.
Given [1, 2, 3, 4], return [1, 3, 2, 4]
Do it in-place.
*/

