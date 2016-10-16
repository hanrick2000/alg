/*
Find K-th largest element in an array.
You can swap elements in the array
Example
In array [9,3,2,4,8], the 3rd largest element is 4.
In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
Challenge 
O(n) time, O(1) extra memory.
[1,2,3,4,5]是最坏情况, O(n)
对撞型指针
*/
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (k <= 0) return 0;
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    public int helper(int[] nums, int l, int r, int k) { //返回的是第k大的元素
        if (l == r) return nums[l];
        int position = partition(nums, l, r); //position是在l,r在哪里划分开, 0-based
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }
    public int partition(int[] nums, int l, int r) {
        int left = l
        int right = r;
        int pivot = nums[left];
        while (left < right) { //这是从小到大排序
            while (left < right && nums[right] >= pivot) { //要不要等于???
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
    }
}


// my first submit version
class Solution{
    public int kthLargestElement(int k, int[] nums){
        if(k<=0) return 0;
        if(nums==null || nums.length==0) return 0;
        return helper(nums, 0, nums.length, nums.length - k + 1); //nums.length-k+1表示一个升序列中, 第k大的数
    }
    public int helper(int[] nums, int l, int r, int k){
        if(l == r) return nums[l];
        int idx = partition(nums, l, r);
        if(idx + 1 == k) return nums[idx];
        else if(idx + 1 < k) return helper(nums, idx + 1, r , k);
        else return helper(nums, l, idx - 1, k);
    }
    public int partition(int[] nums, int l, int r){
        int left = l;
        int right = r;
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
