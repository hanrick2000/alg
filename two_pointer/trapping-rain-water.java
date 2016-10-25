//Version 0: Two pointer
public class Solution {
    public int trapRainWater(int[] heights) {
        int left = 0;
        int right = heights.length - 1; 
        int res = 0;
        if(left >= right){
            return res;
        }
        int leftheight = heights[left];
        int rightheight = heights[right];
        while(left < right) { //一个槽一个槽的算
            if(leftheight < rightheight) { //如果左边界 比 右边界 低
                left ++; //看左边界的右边一个位置
                if(leftheight > heights[left]) { //如果左边界比其右边一个位置高
                    res += (leftheight - heights[left]); //高多少就是能存放多少水
                } else {
                    leftheight = heights[left]; //如果左边界比其右边相邻位置低, 则这个右边位置不能存水, 更新一下左边界的高度
                }
            } else { //如果左边界比右边界高
                right --;  //看右边界左边的一个位置
                if(rightheight > heights[right]) { //如果右边界比其左边一个位置高
                    res += (rightheight - heights[right]); //高多少就是能存放多少水
                } else {
                    rightheight = heights[right]; //如果右边界比左边相邻位置低, 则这个左边相邻位置不能存水, 更新一下右边界的高度
                }
            }
        }
        return res;
    }
}

// Version 1
public class Solution {
    public int trapRainWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] maxHeights = new int[heights.length + 1];
        maxHeights[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
        }
        int max = 0, area = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            area += Math.min(max, maxHeights[i]) > heights[i]
                    ? Math.min(max, maxHeights[i]) - heights[i]
                    : 0;
            max = Math.max(max, heights[i]);
        }
        return area;
    }
}

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
Challenge 
O(n) time and O(1) memory
O(n) time and O(n) memory is also acceptable.
能灌多少水
*/


//Two pointer, 对撞型, 灌水类

