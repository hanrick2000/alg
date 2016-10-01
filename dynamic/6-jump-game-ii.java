/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
如果到不了last index, 则返回Integer.MAX_VALUE
*/

// version 1: Dynamic Programming
// 这个方法，复杂度是 O(n^2)，会超时，但是依然需要掌握。
public class Solution {
    public int jump(int[] A) {
        // state
        int[] steps = new int[A.length]; //steps[j]表示从起点到位置j最少需要多少步
        // initialize
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        // function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) { //steps[j] != Integer.MAX_VALUE表示从起点可以到j, j+A[j]>=i表示从起点可以到i
                    steps[i] = Math.min(steps[i], steps[j] + 1); //这里是取j从0到i-1之间, 如果这个j可以到达i, 从满足这些的j位置中取一个steps[j]最小的
                    //steps[i] = steps[j] + 1; 不好理解, 还是用上面的
                    //break; 其中break即体现了MIN操作，最开始满足条件的j即为最小步数。
                }
            }
        }
        // answer
        return steps[A.length - 1];
    }
}


// version 2: Greedy, O(n)
//自顶向下使用farthest记录从坐标0出发能到达的最远坐标，
//遍历当前start与end之间的坐标，若i+A[i] > farthest时更新farthest(寻找最小跳数),
//当前循环遍历结束时递推end = farthest。end >= A.size() - 1时退出循环，返回最小跳数.
public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) { // end表示在上一次jump时, 所能达到的最远坐标
            int farthest = end; //每次while循环都初始化farthest, farthest是从坐标0出截止到end坐标(包含了end坐标的跳数)所能达到的最远坐标
            for (int i = start; i <= end; ++i) {//这里for循环就是为了找到在上一次jump后, 在区间[start, end]内的所有跳中, 能达到的最远坐标
                if (i + A[i] >= farthest) {
                    farthest = i + A[i];
                }
            }

            if (end < farthest) {
                ++jumps;
                start = end + 1;
                end = farthest; //把farthest更新到end, end是在while循环见保存的最远位置
            } else {
                // cannot jump to the end
                return -1;
            } 
        }
        return jumps;
    }
}
