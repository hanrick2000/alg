//my version 先按照负数|正数划分开, 然后根据负数和正数的个数, 确定swap的范围
class Solution {
    public void rerange(int[] A) {
        // partition into negative | positive
        int left = 0;
        int right = A.length - 1;
        int pivot = A[0];
        while(left < right){
            while(left < right && A[right] >= 0){
                right--;
            }
            A[left] = A[right];
            while(left < right && A[left] <= 0){
                left++;
            }
            A[right] = A[left];
        }
        A[left] = pivot;
        int negative_count = 0;
        // judge number of negative and positive which one is larger
        if(pivot <= 0){
            negative_count = left+1;
        }else{
            negative_count = left;
        }
        int positive_count = A.length - negative_count;
        if(negative_count > positive_count){
            //-7 -3 -2 -1 5 4 6
            left = 1;
            right = A.length - 1;
        }else if(negative_count < positive_count){
            //-3 -2 -2 4 5 6 7
            left = 0;
            right = A.length - 2;
        }else if(negative_count == positive_count){
            //-3 -2 -2 5 6 7
            left = 0;
            right = A.length - 1;
        }
        while(left<right){
            swap(A, left, right);
            left=left+2;
            right=right-2;
        }
    }
    public void swap(int[] A, int left, int right){
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}





//这是一个用了额外空间的solution
class Solution {
    int[] subfun(int[] A,int [] B, int len) {
        int[] ans = new int[len];
        for(int i = 0; i * 2 + 1 < len; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
        }
        if(len % 2 == 1) {
            ans[len - 1] = A[len / 2];
        }
        return ans;
    }
    public void rerange(int[] A) {
        int[] Ap = new int[A.length];
        int totp = 0;
        int totm = 0;
        int[] An = new int[A.length];
        int[] tmp = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                Ap[totp] = A[i];
                totp += 1;
            } else {
                An[totm] = A[i];
                totm += 1;  
            }   
        }
        if(totp > totm) {
            tmp = subfun(Ap, An, A.length);
        } else {
            tmp = subfun(An, Ap, A.length);
        }
        for (int i = 0; i < tmp.length; ++i) {
            A[i] = tmp[i];
        }
    }
}

/*
Given an array with positive and negative integers. 
Re-range it to interleaving with positive and negative integers.

You are not necessary to keep the original order of positive integers or negative integers.

Given [-1, -2, -3, 4, 5, 6], after re-range, 
it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.

Challenge 
Do it in-place and without extra memory.
*/
