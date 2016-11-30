//跟Traverse版的in-order traversal很像, 但是遍历过程中根据k1和k2进行剪枝
public class Solution {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        helper(root, k1, k2, results);
        return results;
    }
    private void helper(TreeNode root, int k1, int k2, ArrayList<Integer> ret) {
        if (root == null) {
            return;
        }
        if (root.val > k1) { //根大于target, 才可以继续向左子树走, 看图就很好想
            helper(root.left, k1, k2, ret);
        }
        if (root.val >= k1 && root.val <= k2) {
            ret.add(root.val);
        }
        if (root.val < k2) {
            helper(root.right, k1, k2, ret);
        }
    }
}

//可以改成非递归形式, 先找到这个点, 然后开始中序遍历, 直到超过范围退出
public class Solution {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(root == null){
            return results;
        }
        //中序遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                return results;
            }
            root = stack.pop();
            if(root.val >= k1 && root.val <= k2){
                results.add(root.val);
            }
            if(root.val > k2){ //提前结束
                return results;
            }
            root = root.right;
        }
    }
}


Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
Find all the keys of tree in range k1 to k2. 
i.e. print all x such that k1<=x<=k2 and x is a key of given BST. 
Return all the keys in ascending order.
Example
If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
    20
   /  \
  8   22
 / \
4   12
root=20
root=8
root=12
