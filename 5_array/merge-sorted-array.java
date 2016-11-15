class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int last = m + n - 1;
        while(m > 0 && n > 0){
            if(A[m - 1] > B[n - 1]){
                A[last] = A[m - 1];
                m--;
                last--;
            }else{
                A[last] = B[n - 1];
                n--;
                last--;
            }
        }
        if(n == 0){ //这个其实可以省略
            while(m > 0){
                A[last] = A[m - 1];
                m--;
                last--;
            }
        }
        if(m == 0){
            while(n > 0){
                A[last] = B[n - 1];
                n--;
                last--;
            }
        }
    }
}
Given two sorted integer arrays A and B, merge B into A as one sorted array.
Notice
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
Example
A = [1, 2, 3, empty, empty], B = [4, 5]
After merge, A will be filled as [1, 2, 3, 4, 5]
