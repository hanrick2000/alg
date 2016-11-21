// 方法一
public class Solution {
    public int countBattleships(char[][] board) {
        int len1 = board.length;
        if(len1 == 0){
            return 0;
        }
        int len2 = board[0].length;
        int ans = 0;
        for (int i = 0; i < len1; i++){
            for(int j = 0 ; j < len2; j++){
                if(board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')){
                    ans ++;
                }
            }
        }
        return ans;
    }
}

// 方法二
public class Solution {
    public int countBattleships(char[][] board) {
        int len1 = board.length;
        if(len1 == 0) {
            return 0;
        }
        int len2 = board[0].length;
        int ans = 0;
        int dx[4] = {0, 0, -1, 1};
        int dy[4] = {-1, 1, 0, 0};
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(board[i][j] == 'X'){
                    board[i][j] = '.';//标记已经访问过
                    ans++;
                    int pos1 = i;
                    int pos2 = j;
                    for(int k = 0; k < 4; k++){
                        //一直沿着同一个方向搜索
                        while(pos1 + dx[k] >= 0 && pos1 + dx[k] < len1 && pos2 + dy[k] >= 0 && pos2 + dy[k] < len2 && board[pos1+[k]][pos2+dy[k]] == 'X'){
                            board[pos1 + dx[k]][pos2 + dy[k]] = '.';
                            pos1 += dx[k];
                            pos2 += dy[k];
                        }
                    }
                }
            }
        }
        return ans;
    }
}

/*
给定一个由'X'和'.'构成的二维字符数组，统计其中“战舰”的数目。“战舰”指的是横向或者是纵向的连续的1-n个"X"。
给定的输入保证不同的“战舰”不相邻，不存在非法输入。
样例输入：
输入：
X..X
...X
...X
输出：2

下面的输入是非法的，因为存在相邻的“战舰”。
...X
XXXX
...X

解答:
看到这个题目，我们容易联想到迷宫类或者地图类题目，
不同的是本题不需要找到路径，需要找到的是有多少个连续的'X'区域。
所以我们容易想到利用DFS搜索，搜索的同时标记已经走过的区域(变成'.')，每次碰到没有走过的区域就将最终结果加一，最后得到的结果就是所求的“战舰”数目。

另外，注意到本题有其特殊之处，每个战舰必须是1*N或者N*1的，因此，我们可以保证每次一直沿着同一个方向搜索就可以找到属于同一艘“战舰”的所有"X"。

Follow-up 挑战 

上述搜索解法已经能够顺利解决本题。时间复杂度为O(m*n),空间复杂度为O(1),但是我们需要修改board数组中的值。
或者如果不修改数组中值的话，我们需要另外开一个数组记录该位置是否已经访问过，空间复杂度就成为O(m*n)了。
我们能否不修改原数组，同时只遍历一次原数组，只用O(1)的空间复杂度解决这个问题？

注意到，题目保证输入的数据一定是合法的，而合法的输入数据中，不同的“战舰”一定不相邻，
因此，不同战舰的“船头”也一定不相邻。
所以，对于这道题目，我们仅仅通过计数有多少个船头就可以得到结果。
而一艘战舰要么是1*N的，要么是N*1的，
即战舰的方向是向右或者向下的，对于找到了一个"X", “船头”的左边和上边一定不是"X", 而非船头的左边或者上边一定是'X'，否则就不是合法的输入。

面试官角度分析 
本题属于中等偏下难度，主要考察面试者搜索的思想。
如果能够利用DFS解决本题就可以达到hire的程度，如果能够利用本题输入数据的特殊之处给出O(1)的空间复杂度的解法，可以达到strong hire 。
*/
