public class Solution{
    public int climbStairs(int n){
        //corner case
        if (n <=1) {
            return 1;
        }
        //state
        int[] res = new int[2]; //f[i]表示跳到第i个位置的方案总数
        //init
        res[0] = 1;
        res[1] = 1;
        //function
        for(int i = 2; i <= n; i++) {
            res[i%2] = res[(i-1)%2] + res[(i-2)%2];
        }
        //result
        return res[n%2];
    }
}

//改成%2的滚动数组
public class Solution {
    public int climbStairs(int n) {
        //异常检测
        if (n <= 1) return 1;
        //state
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}

/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example
Given an example n=3 , 1+1+1=2+1=1+2=3
return 3
state:      f[i]表示跳到第i个位置的方案总数
function:   f[i] = f[i-1] + f[i-2]
initialize: f[0] = 1
answer:     f[n] // index from 0~n
*/
