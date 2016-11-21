public class Solution {
    public int sum;
    public int totalNQueens(int n) {
        sum = 0;
        int[] solution = new int[n];
        helper(solution, 0);
        return sum;
    }
    public void helper(int[] solution, int row) {
        int n = solution.length;
        if (row == n) {
            sum ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(solution, row, i)) {
                solution[row] = i;
                helper(solution, row + 1);
                solution[row] = 0;
            }
        }
    }
    public boolean isValid(int[] solution, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (solution[i] == col) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(col - solution[i])) {
                return false;
            }
        }
        return true;
    }
}

/*
Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.
Example
For n=4, there are 2 distinct solutions.
Tags 
Recursion
*c boolean isValid(int[] solution, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (solution[i] == col) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(col - solution[i])) {
                return false;
            }
        }
        return true;
    }
}/
