// version 1  Divide and Conquer
class ResultType {
    boolean is_bst;
    int maxValue, minValue;
    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root); //调用helper方法
        return r.is_bst; //返回是否是合法的BST
    }
    private ResultType validateHelper(TreeNode root) { //helper是个递归的过程
        if (root == null) { //如果root是null, 那么就返回, null是个合法的BST, 这是递归的终止条件
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = validateHelper(root.left); //看看左儿子是不是合法的BST
        ResultType right = validateHelper(root.right); //右儿子是不是合法的BST
        if (!left.is_bst || !right.is_bst) { //如果左、右有一个不是合法的, 那么root也不是合法的BST
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }
        if (root.left != null && left.maxValue >= root.val ||
              root.right != null && right.minValue <= root.val) { //如果左、右儿子都是合法的, 那么看看结合root的值是不是合法的BST
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, //如果是合法的, 那么返回是合法的BST, 并更新ResultType的max和min
                              Math.max(root.val, right.maxValue),
                              Math.min(root.val, left.minValue));
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
