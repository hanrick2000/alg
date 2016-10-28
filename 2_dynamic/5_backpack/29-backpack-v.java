public class Solution{
    public int backPackV(int[] nums, int target){
        // state
        int[][] f = new int[nums.length + 1][target + 1]; //前i个物体放入容量是j的包中, 放满的方案个数
        // init
        f[0][0] = 1; //把前0个物品放入放满容量是0的袋子, 有1种方案
        // function
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= target; j++){
                f[i][j] = f[i - 1][j];
                if(j >= nums[i - 1]){ //notice: nums[i-1]
                    f[i][j] = f[i - 1][j] + f[i - 1][j - nums[i - 1]]; //唯一要改的地方
                }                            // ^
            }      
        }
        // result
        return f[nums.length][target];
    }
}

//画个模拟图就能分析出来, 分成放和不放最后一个物品来分析
//有模拟图

/*
public class Solution {
    public int backPackV(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < nums.length; ++i)
            for (int  j = nums[i]; j <= target; ++j)
                f[j] += f[j - nums[i]];
        return f[target];
    }
}
*/

/*
Given n items with size nums[i] which an integer array and all positive numbers. 
An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
Each item may only be used once, 每个物品只能用一次, 求装满次数
Example
Given candidate items [1,2,3,3,7] and target 7,
A solution set is: 
[7]
[1, 3, 3]
return 2
*/
