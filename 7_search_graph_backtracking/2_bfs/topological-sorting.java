public class Solution {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}

/*
Given an directed graph, a topological order of the graph nodes is defined as follow:
1 For each directed edge A -> B in graph, A must before B in the order list.
2 The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.
Notice
You can assume that there is at least one topological order in the graph.
Clarification
Learn more about representation of graphs
Example
For graph as follow:
有个图
The topological order can be:
[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
Challenge 
Can you do it in both BFS and DFS?

Tags 
LintCode Copyright, Geeks for Geeks, Depth First Search, Breadth First Search

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { 
        label = x; 
        neighbors = new ArrayList<DirectedGraphNode>(); 
    }
};


1) 计算所有点的入度，用HashMap保存。
2) 将入度为0的点加入queue中和result中，将queue中节点出队，将出队节点所有neighbor的入度减少1。
3) 重复2直到所有点都被加入result中。
需要注意的是，如果有对HashMap做删除操作，不能再用原来的迭代器继续迭代，需要从头用新的迭代器进行迭代。
*/
