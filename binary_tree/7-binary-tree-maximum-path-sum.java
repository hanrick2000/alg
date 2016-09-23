//Hard
public class Solution {
    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点, 最大路径只的是路径和最大值, 关键是从root开始往下走
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点, 是以root为跟的任意子树
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    private ResultType helper(TreeNode root) {//递归
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
                                                                                    //这里就是比较算上root形成的新路径, 跟以root的左右孩子为根的具有maxPath子树, 哪个路径和更大
        /*
        SinglePath也定义为，至少包含一个点(上面的更好理解一些)
        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, Math.max(left.singlePath, 0) + Math.max(right.singlePath, 0) + root.val); //实际跟上面一个意思, 这里的singlePath可能小于0, 而上面的不可能小于0
        */

        return new ResultType(singlePath, maxPath);
    }
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root); //调用helper
        return result.maxPath; //返回ResultType的maxPath
    }
}

/*
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
*/
