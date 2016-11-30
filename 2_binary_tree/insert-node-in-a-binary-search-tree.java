// Non Recursion
public class Solution {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null){
            return node;
        }
        if (node == null){
            return root;
        }
        TreeNode rootcopy = root;
        while (root != null) {
            if (root.val <= node.val && root.right == null) { //当root小于target, 且root右子树为空, 那么把target插入右子树
                root.right = node;
                break;
            } else if (root.val > node.val && root.left == null) { //如果root大于target, 且root左子树为空, 那么把target插入左子树
                root.left = node;
                break;
            } else if(root.val <= node.val) { //找到有空的位置为止
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return rootcopy;
    }
}

// Recursion
public class Solution {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}


Given a binary search tree and a new tree node, insert the node into the tree. 
You should keep the tree still be a valid binary search tree.
You can assume there is no duplicate values in this tree + node.
Example
Given binary search tree as follow, after Insert node 6, the tree should be:
  2             2
 / \           / \
1   4   -->   1   4
   /             / \ 
  3             3   6
Challenge 
Can you do it without recursion?
