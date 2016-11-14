public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        long max_floor = 0;
        long i = 1;
        while(true){
            max_floor += i;
            if(max_floor >= n){
                return (int)i;
            }
            i++;
        }
    }
}

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        //state
        int[] f = new int[n + 1]; //f[i]表示第i层最少需要尝试几次
        //init
        f[0] = 0;
        f[1] = 1;
        //function
        for(int i = 2; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++){
                f[i] = Math.min(f[i], 1 + Math.max(j - 1, f[i - j]));
            }
        }
        //result
        return f[n];
    }
}

There is a building of n floors. 
If an egg drops from the k th floor or above, it will break. 
If it's dropped from any floor below, it will not break.
You're given two eggs, 
Find k while minimize the number of drops for the worst case. 
Return the number of drops in the worst case.
Clarification
For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ... kth floor. 
But in this worst case (k = 10), you have to drop 10 times.
Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, in the worst case (for example, k = 9) you have to drop 4 times.
Example
Given n = 10, return 4.
Given n = 100, return 14.

/*
假设最小尝试次数是x, 第一次在第x层, 
如果蛋碎了, 那么需要在1到x-1层逐一尝试, 共尝试x次,
如果蛋没有碎, 第二次在x + (x - 1)层尝试, 如果碎了, 逐一在x + 1到 2x - 2之间尝试, 共x-2次尝试, 加上第一次蛋没碎时, 和第二次蛋碎的尝试共x次
这样每次尝试的楼层数是
x
x+(x-1)
x+(x-1)+(x-2)
...
x+(x-1)+(x-2)+...+1
如果楼层总共是n层, 那么第一个x使得x+(x-1)+(x-2)+...+1>=n的就是最少尝试次数了
*/

DP思想:
假设f{n}表示从第n层楼扔下鸡蛋，没有摔碎的最少尝试次数。
第一个鸡蛋，可能的落下位置(1,n),第一个鸡蛋从第i层扔下，有两个情况：
碎了，第二个鸡蛋，需要从第一层开始试验，有i-1次机会
没碎，两个鸡蛋，还有n-i层。这个就是子问题了f{n-i} 所以，当第一个鸡蛋，由第i个位置落下的时候，要尝试的次数为1 + max(i - 1, f{n - i})，那么对于每一个i，尝试次数最少的，就是f{n}的值。
状态转移方程如下： f{n} = min(1 + max(i - 1, f{n - i}) ) 其中: i的范围为(1, n), f{1} = 1 完毕。

推广
