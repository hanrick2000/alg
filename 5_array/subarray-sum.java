public class Solution {
    public ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //(sum->index), 当遇到两个index的sum相同时, 表示index1+1到index2是一个解
        map.put(0, -1); //虚拟点, 这样我们才可以记录index1=0的解
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1); 
                ans.add(i);
                return ans;
            }
            map.put(sum, i);
        }
        return ans;
    }
}

/*
Given an integer array, find a subarray where the sum of numbers is zero. 
Your code should return the index of the first number and the index of the last number.
Notice
There is at least one subarray that it's sum equals to zero.
Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/
