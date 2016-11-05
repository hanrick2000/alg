public class Solution {
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        // Divide
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        // Conquer
        return root.val + Math.max(0, Math.max(left, right));
    }
}

Given a binary tree, find the maximum path sum from root. 要从根节点出发
The path may end at any node in the tree and contain at least one node in it.
Example
Given the below binary tree:
  1
 / \
2   3
return 4. (1->3)
