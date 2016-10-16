/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
You may not slant the container.
Example
Given [1,3,2], the max area of the container is 2.
  |
  ||
 |||   = 2

 |||| = 3

   |
 ||||
围水问题
*/

//清晰版本
public class Solution {
    public int maxArea(int[] height) {
        int mxArea = 0; 
        int left = 0; 
        int right = height.length-1;
        while(left<right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            mxArea = Math.max(curArea, mxArea);
            if(height[left]<height[right]) //当l<r时, 基调由l决定, 移动r无意义
                left++;
            else if(height[left]>height[right])
                right--;
            else {
                left++;
                right--;
            }
        }
        return mxArea;
    }
}

public class Solution {
    int computeArea(int left, int right,  int[] heights) {
        return (right-left)*Math.min(heights[left], heights[right]);
    }
    public int maxArea(int[] heights) {
        int left = 0;
        int ans =  0; 
        int right = heights.length - 1;
        while(left <= right) {
            ans = Math.max(ans, computeArea(left, right, heights));
            if(heights[left]<=heights[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}
public class Solution {
    // for any i, the maxium area will be the farthest j that has a[j] > a[i];
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}

/*
思路：
由于ai和aj (i<j) 组成的container的面积：S(i,j) = min(ai, aj)*(j-i)
所以对于任何S(i'>=i, j'<=j) >= S(i,j)，
由于j'-i' <= j-i，必然要有min(ai',aj')>=min(ai,aj)才行。同样可以采用头尾双指针向中间移动：

当a(left) < a(right)时，对任何j<right来说

(1) min(a(left),aj) <= a(left) = min(a(left), a(right))
(2) j-left < right-left

所以S(left, right) > S(left, j<right)。排除了所有以left为左边界的组合，因此需要右移left。

同理，当a(left) > a(right)时，需要左移right。

而当a(left) = a(right)时，需要同时移动left和right。

思路整理：
left = 0, right = n-1
(1) a[left] < a[right], left++
(2) a[left] > a[right], right--
(3) a[left] = a[right], left++, right--
终止条件：left>=right

*/
