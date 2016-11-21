public class Solution {
    public List<List<Integer> > connectedSet(ArrayList<UndirectedGraphNode> nodes){
        HashSet<Integer> hashSet = new HashSet<Integer>(); //先构造并查集
        for (UndirectedGraphNode node: nodes) {
            hashSet.add(node.label);
            for (UndirectedGraphNode neighbour : node.neighbors) {
                hashSet.add(neighbour.label);
            }
        }
        UnionFind uf = new UnionFind(hashSet); 
        for (UndirectedGraphNode node: nodes) {
            for (UndirectedGraphNode neighbour : node.neighbors) {
                int father = uf.find(node.label);
                int neighbourFather= uf.find(neighbour.label);
                if (father != neighbourFather) {
                    uf.union(node.label, neighbour.label);
                }
            }
        }
        return print(hashSet, uf, nodes.size());
    }
    private List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for (int i : hashSet) {
            int fa = uf.find(i);
            if (!hashMap.containsKey(fa)) {
                hashMap.put(fa, new ArrayList<Integer>());
            }
            List<Integer> connected = hashMap.get(fa);
            connected.add(i);
            hashMap.put(fa, connected);
        }
        for (List<Integer> now : hashMap.values()) {
            Collections.sort(now);
            result.add(now);
        }
        return result;
    }
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(HashSet<Integer> hashSet){
            for (Integer now : hashSet) {
                father.put(now, now);
            }
        }
        public int find(int x){
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
        int compressed_find(int x){
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            int next;
            while (x != father.get(x)) {
                next = father.get(x);
                father.put(x, parent);
                x = next;
            }
            return parent;
        }
        void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if (fa_x != fa_y){
                father.put(fa_x, fa_y);
            }
        }
    }
}



// bfs 方法
public class Solution {
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(UndirectedGraphNode node : nodes){
            if(!set.contains(node)){
                bfs(node, set, result);
            }
        }
        return result;
    }
    private void bfs(UndirectedGraphNode node, HashSet<UndirectedGraphNode> set, List<List<Integer>> result){
        List<Integer> connected = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            connected.add(n.label);
            for(UndirectedGraphNode neighbor : n.neighbors){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        Collections.sort(connected);
        result.add(connected);
    }
}


Find the number connected component in the undirected graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

Each connected component should sort by label.

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
