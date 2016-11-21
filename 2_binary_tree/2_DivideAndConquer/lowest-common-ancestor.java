public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) { //情况1
            return root;
        }
        // Divide, 
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        // Conquer
        if (left != null && right != null) { //情况2
            return root;
        } 
        if (left != null && right == null) { //情况3
            return left;
        }else if (right != null && left == null) {
            return right;
        }
        return null;
    }
}





/*
  4
 / \
3   7
LCA(3, 7) = 4

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4
LCA(5, 6) = 7
LCA(6, 7) = 7

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) { //情况3: 当前节点即为两个节点中的一个，此时向父节点返回当前节点。
            return root;
        }
        // Divide, 当前节点不是两个节点中的任意一个，此时应判断左右子树的返回结果。
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        // Conquer
        if (left != null && right != null) { //情况1: 情况若左右子树均返回非空节点，那么当前节点一定是所求的根节点，将当前节点逐层向前汇报。// 两个节点分居树的两侧
            return root;
        } 
        //情况2: 若左右子树仅有一个子树返回非空节点，则将此非空节点向父节点汇报。// 节点仅存在于树的一侧
        if (left != null && right == null) {
            return left;
        }else if (right != null && left == null) {
            return right;
        }
        // 若左右子树均返回NULL, 则向父节点返回NULL. // 节点不在这棵树中
        return null;
    }
}




/*
For the following binary tree:
  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4 情况1
LCA(5, 6) = 7 情况2
LCA(6, 7) = 7 情况3
初次接触这种题可能会没有什么思路，在没有思路的情况下我们就从简单例子开始分析！
分3种情况
情况1: 首先看看3和5，这两个节点分居根节点4的两侧，如果可以从子节点往父节点递推，那么他们将在根节点4处第一次重合；
情况2: 再来看看5和6，这两个都在根节点4的右侧，沿着父节点往上递推，他们将在节点7处第一次重合；
情况3: 最后来看看6和7，此时由于7是6的父节点，故7即为所求。


Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Assume two nodes are exist in tree.
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
*/
