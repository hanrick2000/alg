/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
Challenge 
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
追击型指针
总时间是O(2n), i走一遍, j走一遍
*/
public class Solution {
    public int minimumSize(int[] nums, int s) {
        int j = 0;
        int i = 0;
        int sum =0;
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++) {
            while(j < nums.length && sum < s ) {
                sum += nums[j];
                j++;
            }//直到找到一个sum >= s, 或者j走到了尽头
            if(sum >=s)
                ans = Math.min(ans, j - i);
            sum -= nums[i]; //前进一步就把最靠左边的i去掉
        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }
}

//my first version
public class Solution {
    public int minimumSize(int[] nums, int s){
        int j=0;
        int i=0;
        int sum=0;
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++){
            while(j < num.length && sum < s){
                sum += nums[j];
                j++;
            }
            if(sum >= s)
                ans = Math.min(ans, (j-i));
            sum -= nums[i];
        }
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}

//my second version
public class Solution{
    public int minimumSize(int[] nums, int s){
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(i=0; i<nums.length; i++){
            while(j<nums.length && sum<s){
                sum += nums[j];
                j++; //这个顺序怎么能反呢
            }
            if(sum>=s) ans = Math.min(ans, (j-i));
            sum -= nums[i];
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
