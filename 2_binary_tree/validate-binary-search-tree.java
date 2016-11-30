// Divide and Conquer
public class Solution {
    public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        // Divide
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        // Conquer
        if (!left.is_bst || !right.is_bst) {
            return new ResultType(false, 0, 0);
        }
        if (root.left != null && left.maxValue >= root.val ||
            root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true,
                              Math.max(root.val, right.maxValue),
                              Math.min(root.val, left.minValue));
    }
    class ResultType {
        boolean is_bst;
        int maxValue;
        int minValue;
        ResultType(boolean is_bst, int maxValue, int minValue) {
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
}

// 暂没有理解
// version 2 Traverse
public class Solution {
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}

Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key. 
不存在等于情况, 没有相等的节点
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Example
An example:
  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
   2
     \ 
      4
     /
    3
{2,#,4,3}
