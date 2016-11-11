class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        int[] result = new int[lengthA + lengthB];
        int ib = 0;
        int ia = 0;
        int i = 0;
        while(ia < lengthA && ib < lengthB){
            if(A[ia] >= B[ib]){
                result[i++] = B[ib++];
            }else{
                result[i++] = A[ia++];
            }
        }
        if(ia == lengthA){
            while(ib < lengthB){
                result[i++] = B[ib++];
            }
        }else{
            while(ia < lengthA){
                result[i++] = A[ia++];
            }
        }
        return result;
    }
}


Merge two given sorted integer array A and B into a new sorted integer array.
Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]
Challenge 
How can you optimize your algorithm if one array is very large and the other is very small?
