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
