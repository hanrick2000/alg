public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum < target){
                    count += right -left; 
                    //固定当前的left, 所有right(包括right)左边到left的都满足条件
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}
/*
two-sum-ii, triangle-count 很像

Given an array of n integers nums and a target, 
find the number of index triplets i, j, k with 0 <= i < j < k < n 
that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]

Follow up:
Could you solve it in O(n2) runtime?

Company Tags Google
Tags Array Two Pointers
Similar Problems (M) 3Sum (M) 3Sum Closest
*/
