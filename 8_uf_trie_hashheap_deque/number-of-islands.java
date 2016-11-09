public class Solution {
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(int[] array){
            for(int i = 0; i < array.length; i++){
                father.put(i, i);
            }
        }
        public int compressed_find(int x){
            int parent = father.get(x);
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            int temp = 0;
            int current = x;
            while(current != father.get(current)){
                temp = father.get(current);
                father.put(current, parent);
                current = temp;
            }
            return parent;
        }
        public void union(int a, int b){
            int aFather = compressed_find(a);
            int bFather = compressed_find(b);
            if(aFather != bFather){
                father.put(aFather, bFather);
            }
        }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[] grid1D = new int[n * m];
        int count = 0;
        for(int i = 0; i < n; i++){
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
        UnionFind uf = new UnionFind(grid1D);
        for(int i = 0; i < grid1D.length; i++){
            if(grid1D[i] == 0){
                continue;
            }
            for(int j = 0; j < 4; j++){
                int indexX = i / m + dx[j];
                int indexY = i % m + dy[j];
                int index = indexX * m + indexY;
                if(indexX >= 0 && indexX < n && indexY >= 0 && indexY < m && 1 == grid1D[index]){
                    if(uf.compressed_find(i) != uf.compressed_find(index)){
                        uf.union(i, index);
                        count--;
                    }
                }
            }
        }
        return count;
    }
}

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
