public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    //搜索board上下左右四个边界，找到其边界上'O'的union，将其标为'F'，则board中剩下的'O'必然属于surround region
    //上下左右搜索
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    //用F表明和边界'O'相连的'O'，用'V'表明访问过的点
    static final char Free = 'F';
    static final char Visited = 'V';

    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void surroundedRegions(char[][] board) {
        // Write your code here
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        int row = board.length;
        int col = board[0].length;
        //找出左右边界上'O'的union，并将其都替换为'F'
        for(int i = 0; i < row; i++){
            bfs(board, i, 0);
            bfs(board, i, col - 1);
        }
        //找出上下边界上'O'的union，并将其都替换为'F'
        for(int j = 1; j < col - 1; j++){
            bfs(board, 0, j);
            bfs(board, row - 1, j);
        }
        //遍历整个board，所有标记为'F'的点都属于边界上的'O'的union，将其都变回原来的值；所有标记仍为'O'的点都属于surrounded regions，将其都变为'X'
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'F'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y){
        if(board[x][y] == 'X'){
            return;
        }
        //用bfs算法搜索所有边界上'O'的union的所有点并入列，在出列时将其变为'F'，以表示该点属于边界上'O'的union
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(x, y));

        while(!queue.isEmpty()){
            Node curt = queue.poll();
            board[curt.x][curt.y] = Free;

            for(Node node : expand(board, curt.x, curt.y)){
                queue.offer(node);
            }
        }
    }
    //搜索当前点四周的点，返回合法的点的list
    private ArrayList<Node> expand(char[][] board, int x, int y){
        ArrayList<Node> expansion = new ArrayList<Node>();

        for(int i = 0; i < dx.length; i++){
            int curtX = x + dx[i];
            int curtY = y + dy[i];
            //当其周围的点不越界，同时为'O'时，入列
            if(curtX >= 0 && curtY >= 0 && curtX < board.length && curtY < board[0].length && (board[curtX][curtY] == 'O')){
                //将入列的点标记为'V'，这样可以保证之后不会重复入列
                board[curtX][curtY] = Visited;
                expansion.add(new Node(curtX, curtY));
            }
        }

        return expansion;
    }
}

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X
