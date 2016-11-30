//方法一, BFS
/*
The approach is to do a level order traversal starting from root. 
In the traversal, once a node is found which is NOT a Full Node, 
all the following nodes must be leaf nodes. 
Use the BFS by queue, when first find a node which doesn't have left or right child, 
if find next node has any child, this tree is definitely not a complete binary tree
*/
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int flag = 0;
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp.left != null){
                if(flag == 1){
                    return false;
                }
                q.offer(tmp.left);
            } else {
                flag = 1;
            }
            if(tmp.right != null){
                if(flag == 1){
                    return false;
                }
                q.offer(tmp.right);
            } else {
                flag = 1;
            }
        }
        return true;
    }
}

//方法二, DFS
public class Solution {
    public boolean isComplete(TreeNode root) {
        ResultType result = helper(root);
        return result.isComplete;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isComplete) { //左子树至少是complete
            return new ResultType(-1, false, false);
        }
        // 当左右子树的深度相同时, 左子树必须是full, 右子树必须是complete
        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, right.isFull, true); //左子树一定是full, 当前树是不是full取决于右子树
        }
        // 当左右子树的高度是左边比右边高1, 左子树必须是complete, 右子树必须是full
        if (left.depth == right.depth + 1) {
            if (!left.isComplete || !right.isFull) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, false, true);
        }
        return new ResultType(-1, false, false);
    }
    class ResultType {
        public int depth;
        public boolean isFull; 
        public boolean isComplete;
        ResultType(int depth, boolean isFull, boolean isComplete) {
            this.depth = depth;
            this.isFull = isFull;
            this.isComplete = isComplete;
        }
    }
}



Check a binary tree is completed or not. 
A complete binary tree is a binary tree that every level is completed filled except the deepest level. 
In the deepest level, all nodes must be as left as possible. See more definition
Example
    1
   / \
  2   3
 /
4
is a complete binary. not full

    1
   / \
  2   3
 / \
4   5
is a complete binary. full

     1
   /  \
  2    3
 / \   /
4   5 6
is a is complete binary. not full

    1
   / \
  2   3
 /   /
4   5 
is a not complete binary.

    1
   / \
  2   3
   \
    4
is not a complete binary.

Challenge 
Do it in O(n) time

满二叉树(Full Binary Tree)：
  要么是叶子结点(结点的度为0)，要么结点同时具有左右子树(结点的度为2)。
完全二叉树(Complete Binary Tree)：
  每层结点都完全填满，在最后一层上如果不是满的，则只缺少右边的若干结点。
