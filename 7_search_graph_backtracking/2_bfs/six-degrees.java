public class Solution {
    public int sixDegrees(List<UndirectedGraphNode> graph, //这个graph竟然没有用
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        if (s == t){
            return 0;
        }
        Map<UndirectedGraphNode, Integer> visited = new HashMap<UndirectedGraphNode, Integer>(); //表示从s点出发, 走到key表示的点, 需要value步
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(s);
        visited.put(s, 0); 
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            int step = visited.get(node);
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (visited.containsKey(node.neighbors.get(i))) {
                    continue;
                }
                visited.put(node.neighbors.get(i), step + 1);
                queue.offer(node.neighbors.get(i));
                if (node.neighbors.get(i) == t) {
                    return step + 1;
                }
            }
        }
        return -1;
    }
}


/*
Six degrees of separation is the theory that everyone and everything is six or fewer steps away, 
by way of introduction, 
from any other person in the world, 
so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.
Given a friendship relations, find the degrees of two people, 
return -1 if they can not been connected by friends of friends.

Example
Gien a graph:

1------2-----4
 \          /
  \        /
   \--3--/

{1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2

Gien a graph:

1      2-----4
             /
           /
          3
{1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1

Tags 
Microsoft
*/

/*
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
