//Divide & Conquer
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        // Divide
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);
        // Conquer
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}

//Non Recursion
//http://algorithms.tutorialhorizon.com/inorder-traversal-non-recursive-approach/
//we need to remember that inorder traversal is:
//  first traverse the left node then root followed by the right node.
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        while (true) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                return result;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
    }
}

//Traverse
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> ret) {
        if (root == null){
            return;
        }
        helper(root.left, ret);
        ret.add(root.val);
        helper(root.right, ret);
    }
}

Given a binary tree, return the inorder traversal of its nodes' values.
Example
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
Challenge 
Can you do it without recursion?
