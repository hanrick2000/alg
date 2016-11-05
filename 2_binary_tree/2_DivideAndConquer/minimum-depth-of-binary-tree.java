public class Solution {
    public int minDepth(TreeNode root) {
        int result = 0;
        if(root == null){
            return 0;
        }else if (root.left == null && root.right == null){
            result = 1;
        }else if (root.left == null && root.right != null){
            result = minDepth(root.right) + 1;
        }else if (root.right == null && root.left != null){
            result = minDepth(root.left) + 1;
        }else if (root.right != null && root.left != null){
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            result = Math.min(left, right) + 1;
        }
        return result;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }
    public int getMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}

{1,#,2,3} 这个是3, 一定要走到叶子

    1
     \
       2
      /
     3

{1,#,2,3} 这种表示 
{1,#,2,#,#,3,#} 不对, #下面就不用#了
   

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path 
from the root node down to the nearest leaf node.
Example
Given a binary tree as follow:
  1
 / \ 
2   3
   / \
  4   5
The minimum depth is 2.
