public class Solution {
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val; 
        singlePath = Math.max(singlePath, 0); 
        int maxPath = Math.max(left.maxPath, right.maxPath); 
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val); //子树的maxPath  VS  包括当前根节点的maxPath
        return new ResultType(singlePath, maxPath);
    }
    private class ResultType {
        int singlePath;
        int maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
}

public class Solution {
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val; //计算当前root的singlePath
        singlePath = Math.max(singlePath, 0); //当前的root的singlePath是否值得保留, 小于0就丢弃了
        int maxPath = Math.max(left.maxPath, right.maxPath); //从root的左、有孩子选出具有最大的maxPath
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val); //因为left.singlePath和right.singlePath都是与root相连的, 把root.val算进去能连成一条路径
                                                                                    //这里就是比较包含root形成的新路径, 与以root的左右孩子为根的子树的maxPath, 哪个更大
        return new ResultType(singlePath, maxPath);
    }
    private class ResultType {
        int singlePath; // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点, 最大路径指的是路径和最大值, 关键是从root开始往下走, 这是个中间结果
        int maxPath; // maxPath: 从树中Any to Any的最大路径，这条路径至少包含一个点, 是以root为根的任意子树, 这个一定会有值, 因为最终的答案在这里
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
}

    1
   / \
  2   3
 / \   \
4   5   6
   / \
  8   7
it will be serialized to {1,2,3,4,5,#,6,#,#,7,8}.
get 25 like this:
    1
   / \
  2   3
   \   \
    5   6
   /   
  8     


Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
Example
Given the below binary tree:
  1
 / \
2   3
return 6.
