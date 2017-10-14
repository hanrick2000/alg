public class Solution {
    class TreeNode {
        public int val;
        public String s;
        public TreeNode left, right;
        public TreeNode(int val, String ss) {
            this.val = val;
            this.s = ss;
        }
    }
    ArrayList<String> preOrderTraverse(TreeNode root) {
        ArrayList<String> result = new ArrayList<String>();
        if(root == null){
            return result;
        }
        ArrayList<String> left = preOrderTraverse(root.left);
        ArrayList<String> right = preOrderTraverse(root.right);
        result.add(root.s);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
    public ArrayList<String> convertToPN(String[] expression) {
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
        ArrayList<String> polish = preOrderTraverse(root);
        return polish;
    }
    int getWeight(String a, Integer base) {
        if (a.equals("+") || a.equals("-")){
            return 1 + base;
        }
        if (a.equals("*") || a.equals("/")){
            return 2 + base;
        }
        return Integer.MAX_VALUE;
    }
}

/*
Given an expression string array, 
return the Polish notation of this expression. (remove the parentheses)
Clarification
Definition of Polish Notation:
http://en.wikipedia.org/wiki/Polish_notation
http://baike.baidu.com/view/7857952.htm
Example
For the expression [(5 − 6) * 7] 
(which represented by ["(", "5", "−", "6", ")", "*", "7"]), 
the corresponding polish notation is [* - 5 6 7] 
(which the return value should be ["*", "−", "5", "6", "7"]).
Tags 
LintCode Copyright Stack
*/
