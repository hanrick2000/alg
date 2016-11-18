public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(start + 1 < end) {
            int mid = start + (end- start) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(guess(start) == 0){
            return start;
        }else{
            return end;
        }
    }
}
/*
This problem is a binary search problem has an O(logn) complexity.

We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.
You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
  -1 : My number is lower
   1 : My number is higher
   0 : Congrats! You got it!
Example:
n = 10, I pick 6.
Return 6.
Company Tags Google
Tags Binary Search
Similar Problems (E) First Bad Version (M) Guess Number Higher or Lower II
*/
