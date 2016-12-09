public class Solution {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<Integer>();
        if(n < 1 || m < 1 || operators == null || operators.length == 0){
            return res;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[] isIsland = new boolean[n * m];
        int[] pos = new int[n * m];
        for(int i = 0; i < n; i++){
            for(int j  = 0; j < m; j++){
                int index = i * m + j;
                pos[index] = index;
            }
        }
        UnionFind uf = new UnionFind(pos);
        int count = 0;
        for(Point point : operators){
            int index = point.x * m + point.y;
            isIsland[index] = true;
            count++;
            for(int i = 0; i < 4; i++){
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];
                int nextIndex = nextX * m + nextY;
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && isIsland[nextIndex]){
                    if(uf.find(index) != uf.find(nextIndex)){
                        uf.union(index, nextIndex);
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(int[] array){
            for(int i : array){
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
用UF模版来寻找图中联通分量的个数。用路径压缩来优化搜索。
首先将二维数组转化为1维数组，初始化uf，并用一个数组来记录某一个位置是否被visit
用一个count来记录每一次操作后联通分量的个数。每改变一个位置，就将count加1，并将该位置记录为visit。然后看该位置上下左右四个位置，若其相邻位置不越界且曾经被visit过，并且不属于一个联通分量，则将该位置和其相邻位置union，并将count减1。所有相邻位置看完后剩下的count即为本次操作后的联通分量数。

Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
The list pair has k operator and each operator has two integer A[i].x, A[i].y means that 
you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
Return how many island are there in the matrix after each operator.

0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. 
We only consider up/down/left/right adjacent.

Example
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
return [1,1,2,2].
*/
