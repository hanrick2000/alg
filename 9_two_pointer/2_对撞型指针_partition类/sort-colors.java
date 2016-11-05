public class Solution {
    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int left = 0; //指向0的右边第一个
        int right = a.length - 1; //指向2的左边第一个
        int cur = 0; //当前位置
        while (cur <= right){
            if (a[cur] == 0){
                swap(a, left, cur);
                left++;
                cur++;
            } else if(a[cur] == 1){
                cur++;
            } else if(a[cur] == 2){
                swap(a, right, cur);
                right--;
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}


0 ... 0 1 ... 1 x1 x2 ... xm 2 ... 2
        L       C         R
L: left  0序列的边界位置
C: cur   
R: right 2序列的边界位置

当C是0时, 交换L和C, L和C都++, 因为已经知道L原来是1了
当C是2时, 交换R和C, R--, C不++是因为交换过来的R是未知的, 需要下一次判断
当C是1时, 说明已经就位, C++即可

/*
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
0-red
1-white
2-blue
You are not suppose to use the library's sort function for this problem. 
You should do it in-place (sort numbers in the original array).
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
Challenge 
A rather straight forward solution is a two-pass algorithm using counting sort. 第一遍计数, 第二遍输出
First, iterate the array counting number of 0's, 1's, and 2's, 
then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/
