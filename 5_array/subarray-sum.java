public class Solution {
    public ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        //(sum->index), 当遇到两个index的sum相同时, 表示index1 + 1到index2是一个解
        map.put(0, -1); //虚拟点, 这样我们才可以记录index1 = 0的解
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

0  1 2  3 4
-2 1 2 -3 4

0  -> -1 虚拟点
-2 -> 0  加入-2
-1 -> 1  加入1
1  -> 2  加入2
-2       加入-3
-2 遇到重复key了 表明把当前的值j加入后回到了以前加入到i时的状态, 
说明从i + 1到j之间的和是0才可以做到

*/
