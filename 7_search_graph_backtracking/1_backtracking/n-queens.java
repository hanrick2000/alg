class Solution {
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        int[] solution = new int[n]; //solution[i]表示第i行的Q放在第几列
        helper(results, solution, n, 0);
        return results;
    }
    private void helper(ArrayList<ArrayList<String>> results, int[] solution, int totalRow, int rolNum) {//主体部分
        if (rolNum == totalRow) { //找到一个解
            ArrayList<String> singleResult = translateString(solution);
            results.add(singleResult);
            return;
        }
        for (int colNum = 0; colNum < totalRow; colNum++) {
            if (isValid(solution, rolNum, colNum)) { //如果在当前解solution的基础上可以合法放置(rolNum, colNum)
                solution[rolNum] = colNum;
                helper(results, solution, totalRow, rolNum + 1); //再看下一行
                solution[rolNum] = 0;
            }
        }
    }
    private ArrayList<String> translateString(int[] solution) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < solution.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < solution.length; j++) {
                if (j == solution[i]) {
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
    private boolean isValid(int[] solution, int rowNum, int columnNum) { //判断(rowNum, columnNum)在当前solution上是否能合法放置
        for (int i = 0; i < rowNum; i++) {
            if (solution[i] == columnNum) { //不能在同一列
                return false;
            }
            if (Math.abs(solution[i] - columnNum) == Math.abs(i - rowNum)) { //不能在对角线上
                return false;
            }
        }
        return true;
    }
}

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
Example
There exist two distinct solutions to the 4-queens puzzle:

[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
]
Challenge 
Can you do it without recursion?

Tags 
Recursion Depth First Search
*/
