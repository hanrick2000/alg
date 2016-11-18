public int closestValue(TreeNode root, double target) {
    int ret = root.val;
    while(root != null){
        if(Math.abs(target - root.val) < Math.abs(target - ret)){
            ret = root.val;
        }
        if(root.val > target){
            root = root.left;
        }else{
            root = root.right;
        }
    }
    return ret;
}

/*
Given a non-empty binary search tree and a target value, 
find the value in the BST that is closest to the target.

Note:
1. Given target value is a floating point.
2. You are guaranteed to have only one unique value in the BST that is closest to the target.
Company Tags: Microsoft, Google, Snapchat
Tags: Tree, Binary Search
Similar Problems: (M) Count Complete Tree Nodes (H) Closest Binary Search Tree Value II
*/
