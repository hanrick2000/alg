public class Solution {
    public int triangleCount(int S[]) {
        int ans = 0;
        Arrays.sort(S);
        for(int i = 2; i < S.length; i++) {
            int left = 0;
            int right = i - 1;
            int target = S[i]; //转换为two-sum-ii, 给一个target, 看数组里有多少个两数和大于target
            while(left < right) {
                if(S[left] + S[right] > target) {
                    ans = ans + (right - left); //固定的S[right], 和target, 有多少个解
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return ans;
    }
}

/*
Given an array of integers, 
how many three numbers can be found in the array, 
so that we can build an triangle whose three edges length is the three numbers that we find?
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]

i 0->4
i=0 left=0, right=-1
i=1 left=0, right=0
i=2 left=0, right=1 3+4>6, ans = 0 + (1-0) = 1
    right-- right=0 退出循环
i=3 left=0, right=2 3+6>7, ans = 1 + (2-0) = 3
    right--, right=1 3+4=7, 
    left++, left=1, 退出循环



Given array S = [4,4,4,4], return 4. They are:
[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
*/


