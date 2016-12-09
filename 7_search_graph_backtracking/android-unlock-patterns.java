/*
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
*/
public class Solution {
    public int numberOfPatterns(int m, int n) {
        // Skip array represents number to skip between two pairs
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2; //1与3之间, 跳过的是2
        skip[1][7] = skip[7][1] = 4; //1与7之间, 跳过的是4 
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean visited[] = new boolean[10];
        int rst = 0;
        // DFS search each length from m to n
        for(int i = m; i <= n; ++i) {
            rst += DFS(visited, skip, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric, 这里i-1因为cur=1占用了1
            rst += DFS(visited, skip, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric, 这里i-1因为cur=2占用了一次
            rst += DFS(visited, skip, 5, i - 1);        // 5
        }
        return rst;
    }
    // cur: the current position
    // remain: the steps remaining
    private int DFS(boolean visited[], int[][] skip, int cur, int remain) {
        if(remain == 0){
            return 1;
        }
        visited[cur] = true;
        int rst = 0;
        for(int i = 1; i <= 9; ++i) { //检查从cur到i是否可行
            // If visited[i] is not visited and (two numbers are adjacent or skip number is already visited)
            if(!visited[i] && (skip[cur][i] == 0 || (visited[skip[cur][i]]))) {
                rst += DFS(visited, skip, i, remain - 1);
            }
        }
        visited[cur] = false;
        return rst;
    }
}

/*

The general idea is DFS all the possible combinations from 1 to 9 and skip invalid moves along the way.
We can check invalid moves by using a jumping table. 
e.g. If a move requires a jump and the key that it is crossing is not visited, 
then the move is invalid. 
Furthermore, we can utilize symmetry to reduce runtime, 
in this case it reduced from ~120ms to ~70ms.
I felt clueless when first encountered this problem, 
and considered there must be lots of edge cases. 
Turns out, it's pretty straight forward. 
Hope this solution helps :D
   
   
Given an Android 3x3 key lock screen and two integers m and n,
where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, 
which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
1 Each pattern must connect at least m keys and at most n keys.
2 All the keys must be distinct.
3 If the line connecting two consecutive keys in the pattern passes through any other keys, 
  the other keys must have previously selected in the pattern. 
  No jumps through non selected key is allowed.
4 The order of keys used matters. 有顺序

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Company Tags Google
Tags Dynamic Programming Backtracking
*/
