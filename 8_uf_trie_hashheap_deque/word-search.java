public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || board.length == 0){
            return false;
        }

        if(word == null || word.length() == 0){
            return true;
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean res = findWord(i, j, board, word, 0);

                    if(res){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean findWord(int i, int j, char[][] board, String word, int start){
        //start代表新搜索开始的位置，当和word长度相等时，表示word中所有字符均已匹配
        if(start == word.length()){
            return true;
        }

        //考虑边界
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(start)){
            return false;
        }

        //mark当前位置
        board[i][j] = '#';

        //对当前位置的上下左右四个方向搜索，有一个满足即可
        if(findWord(i - 1, j, board, word, start + 1) || findWord(i + 1, j, board, word, start + 1) || findWord(i, j - 1, board, word, start + 1) || findWord(i, j + 1, board, word, start + 1)){
            return true;
        }

        //将当前位置恢复，以进行下一次新的搜索
        board[i][j] = word.charAt(start);

        return false;
    }
}

对matrix进行搜索，当第一个字符匹配上之后，再看下一个字符。每次对当前位置的上下左右四个方向进行搜索，有一个满足即返回true。在对当前位置的邻接位置搜索之前，用"#"覆盖当前位置的值，这样在新的搜索时不会取到之前取过的重复位置，避免重复。当四个方向均不满足时，将当前位置恢复为原来值，然后对当前位置进行新的搜索。


Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Have you met this question in a real interview? Yes
Example
Given board =

[
  "ABCE",
  "SFCS",
  "ADEE"
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
