Given a binary tree, find the maximum path sum from root.
The path may end at any node in the tree and contain at least one node in it.
/*
   1
-3   4
   8
-5
*/
public class Solution {
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }
}
/* 
主要看局部, 先得到左边和右边的和, 先选出左和右中最大的, 
如果小于0, 则抛弃, 大于0再与root相加
*/
