public class Solution {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return (n>0 && 1162261467 % n==0);
    }
}
/*
Given an integer, write a function to determine if it is a power of three.
Follow up:
Could you do it without using any loop / recursion?
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
Company Tags Google
Tags Math
Similar Problems (E) Power of Two (E) Power of Four
*/
