public class Solution {
    public int partitionArray(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] >= k){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] < k){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        if(nums[left] < k){ //因为返回的是the first index i nums[i] >= k
            return left + 1;
        }
        return left;
    }
}

/*
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.
You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
If all elements in nums are smaller than k, then return nums.length
If nums = [3,2,2,1] and k=2, after partition, [1,2,2,3], a valid answer is 1.
Can you partition the array in-place and in O(n)?
*/                

