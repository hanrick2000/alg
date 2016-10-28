public class Solution {
    public int minimumSize(int[] nums, int s) {
        int j = 0;
        int i = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(i = 0; i < n; i++) {
            while(j < n){ 
                if(sum < s){
                    sum += nums[j];//更新j的状态
                    j++;
                }else{ //满足sum>=s了
                    break;
                }
            }//直到找到一个sum >= s, 或者j走到了尽头
            if(sum >= s) //更新i的状态
                ans = Math.min(ans, j - i);
            sum -= nums[i]; //前进一步就把最靠左边的i去掉
        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }
}

模拟过程
0,1,2,3,4,5
2,3,1,2,4,3 s=7,length=6
 i=0 j=0 sum=0 ans=999
 i=0 j<length && sum<s -> sum=0+A[j=0]=2 j=1
 i=0 j<length && sum<s -> sum=2+A[j=1]=5 j=2
 i=0 j<length && sum<s -> sum=5+A[j=2]=6 j=3
 i=0 j<length && sum<s -> sum=6+A[j=3]=8 j=4
 i=0 j<length && sum>=s 退出while ans=min(999,4-0)=4 sum=8-2=6 
*i=1 j<length && sum<s -> sum=6+A[j=4]=10 j=5  //j不用退回到i开始, 因为已经知道i=0到j＝2的和不满足, 因此i=1到j=2一定也不满足, 直接看i=1到j=3是否满足, 这里sum就是从1到3的和, 因为不满足才把A[j=4]加上
 i=1 j<length && sum>=s 退出while ans=min(4,5-1)=4 sum=10-3=7
 i=2 j<length && sum>=s 退出while ans=min(4,5-2)=3 sum=7-1=6
 i=3 j<length && sum<s -> sum=6+3=9 j=6
 i=3 j>=length && sum>=s -> ans=min(3,6-3)=3 sum=9-2=7
 i=4 j>=length && sum>=s -> ans=min(3,6-4)=2 sum=7-4=3
 i=5 j>=length && sum<s  -> sum=3-3=0
 i走到头了
 ans不是999, 返回2

/*
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return -1 instead.
Given the array [2,3,1,2,4,3] and s = 7, 
the subarray [4,3] has the minimal length under the problem constraint.
Challenge 
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(nlogn).
追击型指针
总时间是O(2n), i走一遍, j走一遍
*/

//Two pointer, 窗口类

