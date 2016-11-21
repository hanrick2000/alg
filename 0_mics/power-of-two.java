public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}
/*
Given an integer, write a function to determine if it is a power of two.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
Company Tags Google
Tags Math Bit Manipulation
Similar Problems (E) Number of 1 Bits (E) Power of Three (E) Power of Four
*/
