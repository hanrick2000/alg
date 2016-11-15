class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if(len % 2 == 1){
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }
    public int findKth(int[] A, int index_A, int[] B, int index_B, int k){
        if(index_A >= A.length){
            return B[index_B + k - 1];
        }
        if(index_B >= B.length){
            return A[index_A + k - 1];
        }
        if(k == 1){
            return Math.min(A[index_A], B[index_B]);
        }
        int key_A = Integer.MAX_VALUE;
        int key_B = Integer.MAX_VALUE;
        if(index_A + k / 2 - 1 < A.length){
            key_A = A[index_A + k / 2 - 1];
        }
        if(index_B + k / 2 - 1 < B.length){
            key_B = B[index_B + k / 2 - 1];
        }
        if(key_A < key_B){
            return findKth(A, index_A + k / 2, B, index_B, k - k / 2);
        }
        return findKth(A, index_A, B, index_B + k / 2, k - k / 2);
    }
}

There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays.
Example
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
Given A=[1,2,3] and B=[4,5], the median is 3.
Challenge 
The overall run time complexity should be O(log (m+n)).
