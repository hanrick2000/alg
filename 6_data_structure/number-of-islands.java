public class Solution {
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = grid.length;
        int m = grid[0].length;
        int[] grid1D = new int[n * m];
        int count = 0;
        for(int i = 0; i < n; i++){ //先构造grid1D
            for(int j = 0; j < m; j++){
                int index = i * m + j;
                if(grid[i][j] == true){
                    grid1D[index] = 1;
                    count++;
                }else{
                    grid1D[index] = 0;
                }
            }
        }
        UnionFind uf = new UnionFind(grid1D); //把grid1D放入并查集
        for(int i = 0; i < grid1D.length; i++){
            if(grid1D[i] == 0){
                continue;
            }
            for(int j = 0; j < 4; j++){
                int indexX = i / m + dx[j]; //indexX和indexY是需要搜索的当前点的四周
                int indexY = i % m + dy[j];
                int index = indexX * m + indexY; //这个是对应在grid1D中的索引
                if(indexX >= 0 && indexX < n && indexY >= 0 && indexY < m && 1 == grid1D[index]){
                    if(uf.find(i) != uf.find(index)){
                        uf.union(i, index); //如果四周有1的, 那么就进行合并
                        count--;
                    }
                }
            }
        }
        return count;
    }
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(int[] array){
            for(int i = 0; i < array.length; i++){
                father.put(i, i);
            }
        }
        public int find(int x){
            int parent = father.get(x);
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            int temp = 0;
            while(x != father.get(x)){
                temp = father.get(x);
                father.put(x, parent);
                x = temp;
            }
            return parent;
        }
        public void union(int a, int b){
            int aFather = find(a);
            int bFather = find(b);
            if(aFather != bFather){
                father.put(aFather, bFather);
            }
        }
    }
}

/*
Given a boolean 2D matrix, find the number of islands.
0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. 
We only consider up/down/left/right adjacent.
Example
Given graph:
[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.
*/
