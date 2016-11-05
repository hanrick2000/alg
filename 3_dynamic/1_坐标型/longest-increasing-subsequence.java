public class Solution {
    public int longestIncreasingSubsequence(int[] nums) {
        int max = 0;
        // state
        int[] f = new int[nums.length]; // f[i]表示(从任意某个木桩)跳到第i个木桩,最多踩过多少根木桩
        // init
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        // function
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) { //这第二重循环就是为了"枚举"以i为结尾的LIS的前一个数应该是什么
                if (nums[j] < nums[i]) { //确保形成上升关系, 把i之前的所有j都枚举一下, 选出最大的
                    f[i] = Math.max(f[i], f[j] + 1); //f[i] = max{f[j]+1}, j必须满足 j < i && nums[j] <= nums[i]
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        // result
        return max;
    }
}

/*
状态转移方程是
f[i]表是的是前i个数, 且第i个数是LIS的最后一个数的LIS长度

f[i]表示前i个数的LIS的长度, 这个思路是不行的, 因为不知道LIS中最后一个数是什么, 那么也就不能知道倒数第二个数是什么 ***关键是要知道最后一个数是什么才能比较

Example
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

新讲义:
将n个数看做n个木桩,目的是从某个木桩出发,从前向后,从低往高,看做多能踩多少个木桩。 
state: f[i] 表示(从任意某个木桩)跳到第i个木桩,最多踩过多少根木桩
function: f[i] = max{f[j] + 1}, j必须满足 j < i && nums[j] <= nums[i]
initialize: f[0..n-1] = 1
answer: max{f[0..n-1]}
*/
