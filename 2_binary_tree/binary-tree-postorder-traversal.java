//Divide & Conquer
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        // Divide
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        // Conquer
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;   
    }
}

//后序遍历就是前序遍历(先right后left)的倒序
//Non-Recursion
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> s1 = new Stack<TreeNode>();
    Stack<TreeNode> s2 = new Stack<TreeNode>();
    if (root == null){
        return result;
    }
    s1.push(root);                             //类似preorder,先把root放入栈里
    while (s1.isEmpty() == false) {
        TreeNode node = s1.pop();              //取出栈顶元素, 放入s2中, preorder是直接放入了结果集
        s2.push(node);
        if(node.left != null){                 //注意, 这里与preorder时顺序相反
            s1.push(node.left);
        }
        if(node.right != null){
            s1.push(node.right);
        }
    }
    while(s2.isEmpty() == false){
        result.add(s2.pop().val);              //s2逐个出栈放入结果集
    }
    return result;
}

//Iterative
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;
    if (root == null) {
        return result;
    }
    stack.push(root);
    while (!stack.empty()) {
        curr = stack.peek();
        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
            if (curr.left != null) {
                stack.push(curr.left);
            } else if (curr.right != null) {
                stack.push(curr.right);
            }
        } else if (curr.left == prev) { // traverse up the tree from the left
            if (curr.right != null) {
                stack.push(curr.right);
            }
        } else if (curr.right == prev) { // traverse up the tree from the right
            result.add(curr.val);
            stack.pop();
        }
        prev = curr;
    }
    return result;
}

ven a binary tree, return the postorder traversal of its nodes' values.
Example
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
 
return [3,2,1].

Challenge 
Can you do it without recursion?
