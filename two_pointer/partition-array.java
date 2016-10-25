public class Solution {
    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        right = nums.length - 1;
        while (left < right) {
            while (left <= right && nums[left] < k) { //********
                left++; //left 所在位置是the first indwx nums[i]>=k
            }
            while (left < right && nums[right] >= k) {
                right--; //[right, )right右边一定是>=k的
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}


如果***号处是left < right, 有case过不了, [7,7,,9,8,6,6,8,7,9,8,6,6] target=10, left的意义是the first index i nums[i] >= k

Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right

Return the partitioning index, i.e the first index i nums[i] >= k.

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

If nums = [3,2,2,1] and k=2, after partition, [1,2,2,3], a valid answer is 1.

Can you partition the array in-place and in O(n)?
                
