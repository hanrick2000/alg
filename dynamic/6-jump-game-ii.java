// version 1: Dynamic Programming
// 这个方法，复杂度是 O(n^2)，会超时，但是依然需要掌握。
public class Solution {
    public int jump(int[] A) {
        //state
        int[] f = new int[A.length]; //state: f[i]表示从起点到位置i最少需要多少步
        //init
        f[0] = 0;
        for (int i = 1; i < A.length; i++){
            f[i] = Integer.MAX_VALUE;
        }
        //fuction
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] != Integer.MAX_VALUE && j + A[j] >= i) { //f[j] != Integer.MAX_VALUE表示从起点可以到j, j+A[j]>=i表示从起点可以到i
                    f[i] = Math.min(f[i], f[j] + 1); //这里是取j从0到i-1之间, 如果这个j可以到达i, 从满足这些的j位置中取一个f[j]最小的
                    //f[i] = f[j] + 1; 不好理解, 还是用上面的
                    //break; 其中break即体现了MIN操作，最开始满足条件的j即为最小步数。
                }
            }
        }
        //result
        return f[A.length - 1];
    }
}

// version 2: Greedy, O(n)
//自顶向下使用farthest记录从坐标0出发能到达的最远坐标，
//遍历当前start与end之间的坐标，若i+A[i] > farthest时更新farthest(寻找最小跳数),
//当前循环遍历结束时递推end = farthest。end >= A.size() - 1时退出循环，返回最小跳数.
//贪心策略: 每一次跳, 都是在上一跳的可以达到的区间内选择能够跳的最远的那个位置, eg 1 4 9 1 1 1 1 1 1, 第一跳在1, 第二跳到4, 4的可调范围是后面的4个格子, 9是最远的距离, 则落在9那里
public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) return -1;
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) { // end表示在上一次跳时 所能达到的最远距离的坐标
            int farthest = end; //上一跳的最远距离
            for (int i = start; i <= end; ++i) {//这里for循环就是为了找到在上一次后能达到的区间在区间[start, end]内, 能达到的最远坐标, 更新这一跳能达到的最远距离
                if (i + A[i] > farthest) {
                    farthest = i + A[i];
                }
            }
            if (end < farthest) {
                ++jumps;
                start = end + 1;
                end = farthest; //把farthest更新到end, end是在while循环见保存的最远位置
            } else {
                return -1;// 如果farthest >= end, 表明在上一跳后, 能达到的区间里面, 所有能达到的最远距离farthest, 没有能够超过上一跳所能达到的最远距离end的, 3 2 1 0 4
            } 
        }
        return jumps;
    }
}
// 3 2 1 0 4
/*
 0   1 2   3 4   5 6 7 8
[2] [3 1] [5 2] [1 3 1 -]
上面这个例子, 第一次搜索2, 然后更新搜索范围到了坐标1-2. 第二次搜索1-2坐标对应的跳数3,1, 最远可以到4, 更新搜索范围到了坐标3-4, 第三次搜索3-4坐标对应的5,2, 更新搜索范围到了坐标5-8, 然后发现其超过了数组当前额长度, 说明可以跳到, 切是最短跳数

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 f to the last index.)
如果到不了last index, 则返回Integer.MAX_VALUE

*/
