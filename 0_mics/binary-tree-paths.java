public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val), result); 
        return result;
    }
    private void helper(TreeNode root, String path, List<String> result) {
        //递归定义: 把root加入到path中, 如果遇到叶子就放入result
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        //递归拆解: 根据左右儿子进行拆解
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}

/*
Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:
["1->2->5", "1->3"]
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
Company Tags Google Apple Facebook
Tags Tree Depth-first Search
Similar Problems (M) Path Sum II
*/
