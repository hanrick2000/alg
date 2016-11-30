public class Solution {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        ArrayList<ParentTreeNode> pathA = getPath2Root(A);
        ArrayList<ParentTreeNode> pathB = getPath2Root(B);
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        ParentTreeNode lowestAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lowestAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lowestAncestor;
    }
    private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}





public class Solution {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
//先获取从A B节点的到跟的路径
        ArrayList<ParentTreeNode> pathA = getPath2Root(A);
        ArrayList<ParentTreeNode> pathB = getPath2Root(B);
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        ParentTreeNode lowestAncestor = null;
//然后从后往前的遍历这两条路径, 开始的时候一定是相等的, 因为从跟开始嘛
//第一次不等的时候, 表示分叉了, 这时候退出循环, 上一次记录的lowestAncestor就是需要的结果
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lowestAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lowestAncestor;
    }
    
    //路径的顺序是从叶子到跟, 5-7-4
    private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}


Given the root and two nodes in a Binary Tree. 
Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
The node has an extra attribute parent which point to the father of itself. 
The root's parent is null.
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6

LCA(3, 5) = 4
LCA(5, 6) = 7
LCA(6, 7) = 7
