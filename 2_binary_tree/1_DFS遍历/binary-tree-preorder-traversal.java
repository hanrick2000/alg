//Divide & Conquer
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) { //汇报工作
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        // Divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}

//Non-Recursion
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        stack.push(root);                        //最开始root入栈
        while (stack.empty() == false) {         //只要栈非空
            TreeNode node = stack.pop();         //栈顶出栈
            result.add(node.val);                //放入结果
            if (node.right != null) {            //把右节点放入栈
                stack.push(node.right);
            }
            if (node.left != null) {             //把左节点放入栈
                stack.push(node.left);
            }
        }
        return result;
    }
}

//需要一个栈, 根先入栈, 然后while循环栈顶出栈加入结果, 按照先右后左的顺序放入栈


//Traverse
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) { //拿着记事本到处走
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

Given a binary tree, return the preorder traversal of its nodes' values.
Have you met this question in a real interview? Yes
Example
Given:
    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].
Challenge 
Can you do it without recursion?
