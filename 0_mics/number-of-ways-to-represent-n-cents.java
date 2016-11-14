public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int waysNCents(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        int[] cents = new int[]{1, 5, 10, 25};
        for (int i = 0; i < 4; i++) 
            for (int j = 1; j <= n; j++) {
                if (j >= cents[i]) {
                    f[j] += f[j-cents[i]];
                }
            }
        return f[n];
    }
}

Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), write code to calculate the number of ways of representing n cents.

Have you met this question in a real interview? Yes
Example
n = 11

11 = 1 + 1 + 1... + 1
   = 1 + 1 + 1 + 1 + 1 + 1 + 5
   = 1 + 5 + 5
   = 1 + 10
return 4

Tags 
Dynamic Programming Recursion
