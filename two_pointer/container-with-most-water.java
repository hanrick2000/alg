public class Solution {
    public int maxArea(int[] height) {
        int max = 0; 
        int left = 0; 
        int right = height.length-1;
        while(left<right) {
            int cur = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(cur, max);
            if(height[left]<height[right]){ //当l<r时, 基调由l决定, 移动r无意义, 移动了肯定比当前围水面积小
                left++;
            } else if(height[left]>height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}

/*
思路：
由于ai和aj (i<j) 组成的container的面积：S(i,j) = min(ai, aj)*(j-i)
所以对于任何能让S(i'>=i, j'<=j) >= S(i,j)的情况, 因为j'-i' <= j-i，必须要有要min(ai',aj')>=min(ai,aj)才行。同样可以采用头尾双指针向中间移动：

当h_left < h_right时，对任何j<right来说
因为左边界的高度小于右边界的高度, 面积是min(h_left, h_right) * (right-left) 变成了 h_left*(right-left), 如果固定了left, h_left就定了, 左移right必然会让面积变小
所以排除了所有以left为左边界的组合，因此需要右移left。

同理，当h_left) > h_right)时，需要左移right。

而当a(left) = a(right)时，需要同时移动left和right。

思路整理：
left = 0, right = n-1
(1) a[left] < a[right], left++
(2) a[left] > a[right], right--
(3) a[left] = a[right], left++, right--
终止条件：left>=right

*/

/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
You may not slant the container.
Example
Given [1,3,2], the max area of the container is 2.
  |
  ||
 |||  = 2

 |||| = 3

   |
 ||||
围水问题
*/
