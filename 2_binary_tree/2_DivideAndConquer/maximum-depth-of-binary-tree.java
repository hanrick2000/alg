//Divede and Conquer
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

//Traverse version
public class Solution {
    private int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;
        helper(root, 1);
        return depth;
    }
    private void helper(TreeNode node, int curtDepth) {
        if (node == null) {
            return;
        }
        if (curtDepth > depth) {
            depth = curtDepth;
        }
        helper(node.left, curtDepth + 1);
        helper(node.right, curtDepth + 1);
    }
}

Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path 
from the root node down to the farthest leaf node.
Example
Given a binary tree as follow:
  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.
