public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]) + 1, i + 1};
                return result;
            }
            map.put(target - numbers[i], i); 
        }
        int[] result = {};
        return result;
    }
}


/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are NOT zero-based.
You may assume that each input would have exactly one solution
Example
numbers=[2, 7, 11, 15], target=9
return [1, 2]
Challenge 
Either of the following solutions are acceptable:
O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time
*/

//遍历一遍数组, 把(target-A[i],i)放入hash表, 如果遇到了target-A[i],  则找到了答案

//其实不是two pointer问题

