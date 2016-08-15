/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array may contain duplicates.
Given [4,4,5,6,7,0,1,2] return 0.
*/

// version 1: just for loop is enough

/*
public class Solution {
  public int findMin(int[] num) {
    //  这道题目在面试中不会让写完整的程序
    //  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
    //  这种情况使得时间复杂度必须是 O(n)
    //  因此写一个for循环就好了。
    //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
    int min = num[0];
    for (int i = 1; i < num.length; i++) {
      if (num[i] < min)
        min = num[i];
    }
    return min;
  }
}
*/

// version 2: use *fake* binary-search
public class Solution {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    
    int start = 0, end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == nums[end]) {
        // if mid equals to end, that means it's fine to remove end
        // and the smallest element won't be removed
        // 去掉重复的值, 知道不重复, 才能套用最小值出现在无序侧的先验知识
        end--;
      } else if (nums[mid] < nums[end]) {
        // 表明mid右边是有序的, 我们要寻找的最小点一定在无序的一侧
        end = mid;
        // of course you can merge == & <
      } else {
        start = mid;
        // or start = mid + 1
      }
    }
    
    if (nums[start] <= nums[end]) {
      return nums[start];
    }
    return nums[end];
  }
}
