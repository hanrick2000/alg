public class Solution {
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null){
            return 0;
        }
        int len = nums.size();
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        int[] localMin  = new int[len]; //localMin[i]表示以i为最后一个元素的最小值
        int[] globalMin = new int[len]; //globalMin[i]表示第i个位置时的全局最小值
        for (int i = 0; i < len; i++) {
            if( i == 0 ){
                globalMin[i] = localMin[i] = nums.get(i);
            } else {
                localMin[i] = Math.min(localMin[i - 1] + nums.get(i), nums.get(i));
                globalMin[i] = Math.min(globalMin[i - 1], localMin[i]);
            }
            
        }
        return globalMin[len - 1];
    }
}
/*
Given an array of integers, find the subarray with smallest sum.
Return the sum of the subarray.
The subarray should contain one integer at least.
Example
For [1, -1, -2, 1], return -3.
*/
