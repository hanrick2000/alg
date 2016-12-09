//前向型指针 窗口类, 最多是O(2n)时间复杂度, i走一遍, j走一遍, j在前面走, i在后面追
//之所谓快慢指针, i 和 j又构成窗口, 又所谓窗口类
//后面还有利用二分查找的nlogn方法
public class Solution {
    public int minimumSize(int[] nums, int s) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int j = 0; //j是快指针
        for(int i = 0; i < nums.length; i++) { //遍历每个数字, i是慢指针
            while(j < nums.length){ 
                if(sum < s){
                    sum += nums[j];//更新j的状态
                    j++;
                }else{ //满足sum>=s了
                    break;
                }
            }//直到找到一个sum >= s, 或者j走到了尽头
            if(sum >= s){ //更新i的状态
                ans = Math.min(ans, j - i);
            }
            sum -= nums[i]; //前进一步就把最靠左边的i去掉
        }
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        return ans;
    }
}


/*
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
*/

/*
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return -1 instead.
Given the array [2,3,1,2,4,3] and s = 7, 
the subarray [4,3] has the minimal length under the problem constraint.
Challenge 
If you have figured out the O(n) solution, 
try coding another solution of which the time complexity is O(nlogn).
追击型指针
总时间是O(2n), i走一遍, j走一遍



下面我们再来看看O(nlgn)的解法, 这个解法要用到二分查找法.
思路是,我们建立一个比原数组长一位的sums数组,
其中sums[i]表示nums数组中[0, i - 1]的和,然后我们对于sums中每一个值sums[i],
用二分查找法找到sums数组中第一个大于sums[i] + s的位置right, 这段子数组的长度就是right - i
然后我们更新最短长度的距离即可. 代码如下:

public class Solution {
    public int minimumSize(int[] nums, int s) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int[] sums = new int[len + 1];
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= len; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for(int i = 0; i <= len; i++){
            int right = searchRight(i, len, sums[i] + s, sums);
            if(right == len + 1){ 
            //第一次出现sums中找不到sums[i]+s时就说明不用后续找了, 后面的子数组会更短, 其和更不可能满足要求
                break;
            }
            res = Math.min(res, right - i);
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
    private int searchRight(int left, int right, int key, int[] sums){
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(sums[mid] == key){
                left = mid;
            }else if(sums[mid] < key){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(sums[left] >= key){
            return left;
        }else if(sums[right] >= key){
            return right;
        }
        return right + 1;
    }
}
*/

