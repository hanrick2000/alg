//UF
public class Solution {
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(int n){
            for(int i = 0; i < n; i++){
                father.put(i,i);
            }
        }
        public int compressed_find(int x){
            int parent = father.get(x);
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            int temp = 0;
            int fa = x;
            while(fa != father.get(fa)){
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
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
    public boolean validTree(int n, int[][] edges) {
        if(n != edges.length + 1){
            return false;
        }
        if(n == 1){
            return true;
        }
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            if(uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])){
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}


//BFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        //bfs version
        if(n != edges.length + 1){
            return false;
        }

        if(n == 1){
            return true;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        queue.offer(0);
        set.add(0);

        while(!queue.isEmpty()){
            int curt = queue.poll();
            for(int i = 0; i < edges.length; i++){
                if(edges[i][0] == curt && !set.contains(edges[i][1])){
                    queue.offer(edges[i][1]);
                    set.add(edges[i][1]);
                }
                if(edges[i][1] == curt && !set.contains(edges[i][0])){
                    queue.offer(edges[i][0]);
                    set.add(edges[i][0]);
                }
            }
        }

        return set.size() == n;
    }
}

首先tree必须保证n个点只有n-1条边。然后必须保证所有点在一个联通分量中，并且无环。有两种方法：
用UF，将边上的两个点归并到同一个联通分量中，若已经在同一个分量中的两个点之间还有边，则有环
从一个点开始，用BFS，若能遍历所有点则所有点在一个联通分量中
代码如下：

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
