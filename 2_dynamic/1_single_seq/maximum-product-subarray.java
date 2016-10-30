public class Solution {
    public int maxProduct(int[] nums) {
        // state
        int[] max = new int[nums.length + 1]; //前i个数, 且以第i个数为结尾的最大乘积
        int[] min = new int[nums.length + 1]; //前i个数, 且以第i个数为结尾的最小乘积
        // init
        min[0] = 1;
        max[0] = 1;
        int result = nums[0];
        // function
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                max[i] = Math.max(nums[i - 1], max[i - 1] * nums[i - 1]);
                min[i] = Math.min(nums[i - 1], min[i - 1] * nums[i - 1]);
            } else if (nums[i - 1] < 0) {
                max[i] = Math.max(nums[i - 1], min[i - 1] * nums[i - 1]);
                min[i] = Math.min(nums[i - 1], max[i - 1] * nums[i - 1]);
            }
            result = Math.max(result, max[i]);
        }
        // result
        return result;
    }
}

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
