public class Solution {
    class TreeNode {
        public int val;
        public String s;
        public TreeNode left, right;
        public TreeNode(int val, String ss) {
            this.val = val;
            this.s = ss;
            this.left = this.right = null;
        }
    }
    ArrayList<String> postOrderTraverse(TreeNode root) {
        ArrayList<String> result = new ArrayList<String>();
        if(root == null){
            return result;
        }
        ArrayList<String> left = postOrderTraverse(root.left);
        ArrayList<String> right = postOrderTraverse(root.right);
        result.addAll(left);
        result.addAll(right);
        result.add(root.s);
        return result;
    }
    public ArrayList<String> convertToRPN(String[] expression) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int val = 0;
        Integer base = 0;
        for (int i = 0; i < expression.length; i++) {
            if(i != expression.length){
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
                val = getWeight(expression[i], base);
            }
            TreeNode node = new TreeNode(val, expression[i]);
            while(!stack.isEmpty() && node.val <= stack.peek().val){
                node.left = stack.pop();
            }
            if(!stack.isEmpty()){
                stack.peek().right = node;
            }
            stack.push(node);
        }
        TreeNode root = null;
        if(stack.isEmpty()){
            root = null;
        }else{
            root = stack.pop();
            while(!stack.isEmpty()){
                root = stack.pop();
            }
        }
        ArrayList<String> reversePolish = postOrderTraverse(root);
        return reversePolish;
    }
    int getWeight(String a, Integer base) {
        if (a.equals("+") || a.equals("-"))
            return 1 + base;
        if (a.equals("*") || a.equals("/"))
            return 2 + base;

        return Integer.MAX_VALUE;
    }
}

/*
Given an expression string array, 
return the Reverse Polish notation of this expression. (remove the parentheses)
Example
For the expression [3 - 4 + 5] 
(which denote by ["3", "-", "4", "+", "5"]), return [3 4 - 5 +] (which denote by ["3", "4", "-", "5", "+"])
Tags 
LintCode Copyright Stack
*/
