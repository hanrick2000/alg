public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 0; i <= n; i++) 
            for (int j = 1; j <= 3; j++) {
                if (i >= j) {
                    f[i] += f[i-j];
                }
            }
        return f[n];
    }
}

A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

Have you met this question in a real interview? Yes
Example
n=3
1+1+1=2+1=1+2=3=3

return 4

Tags 
Cracking The Coding Interview
