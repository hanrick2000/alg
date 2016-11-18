// version 1: 3 steps
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}


// version 2: two steps
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        // clone nodes    
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}

// version 3: Non-Recursion DFS
class StackElement {
    public UndirectedGraphNode node;
    public int neighborIndex;
    public StackElement(UndirectedGraphNode node, int neighborIndex) {
        this.node = node;
        this.neighborIndex = neighborIndex;
    }
}
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        // use dfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Stack<StackElement> stack = new Stack<StackElement>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        stack.push(new StackElement(node, -1));
        set.add(node);
        while (!stack.isEmpty()) {
            StackElement current = stack.peek();
            current.neighborIndex++;
            // there is no more neighbor to traverse for the current node
            if (current.neighborIndex == current.node.neighbors.size()) {
                stack.pop();
                continue;
            }
            UndirectedGraphNode neighbor = current.node.neighbors.get(
                current.neighborIndex
            );
            // check if we visited this neighbor before
            if (set.contains(neighbor)) {
                continue;
            }
            stack.push(new StackElement(neighbor, -1));
            set.add(neighbor);
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
How we serialize an undirected graph:
Nodes are labeled uniquely.
We use '#' as a separator for each node, and ',' as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
1 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
2 Second node is labeled as 1. Connect node 1 to node 2.
3 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
*/


/*
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         this.label = x; 
 *         this.neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


要clone所有点和边，首先想到的是BFS。
BFS:
1) 首先用BFS遍历所有的点，同时复制。
BFS用一个链表实现，待复制的点进入链表，同时用一个HashMap保存该原始点和其对应的复制点，
出链表时将其neighbor加入链表，其中若neighbor已经进入过链表（用HashMap查询），则不重复进入。
2) 再复制所有的边。遍历BFS链表中每一个点，同时取出HashMap中该点对应的复制点，将该点neighbor对应的复制点全部加入对应复制点的neighbor。
也可以用DFS实现。方法与BFS类似，先遍历所有点并复制，再复制所有边（neighbor）。遍历时采用DFS搜索。
