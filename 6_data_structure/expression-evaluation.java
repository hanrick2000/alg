//先转换成min tree, 然后后续遍历成逆波兰表达式, 最后计算
public class Solution {
    class TreeNode {
        public int val;
        public String s;
        public TreeNode left, right;
        public TreeNode(int val, String str) {
            this.val = val;
            this.s = str;
        }
    }
    public int evaluateExpression(String[] expression) {
        if (expression == null || expression.length == 0) {
            return 0;
        }
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
        List<String> reversePolish = postOrderTraverse(root);
        return evalReversePolish(reversePolish);
    }
    int getWeight(String token, Integer base) {
        if (token.equals("+") || token.equals("-")){
            return 1 + base;
        }
        if (token.equals("*") || token.equals("/")){
            return 2 + base;
        }
        return Integer.MAX_VALUE;
    }
    List<String> postOrderTraverse(TreeNode root){
        List<String> result = new ArrayList<String>();
        if(root == null){
            return result;
        }
        List<String> left = postOrderTraverse(root.left);
        List<String> right = postOrderTraverse(root.right);
        result.addAll(left);
        result.addAll(right);
        result.add(root.s);
        return result; 
    }
    int evalReversePolish(List<String> tokens) { //根据逆波兰表达式计算数值
        int result = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for (String token: tokens) {
            if (!operators.contains(token)) { //如果是数字则入栈
                stack.push(token);
            } else { //如果是符号, 先弹出两个数字
                int right = Integer.valueOf(stack.pop());
                int left = Integer.valueOf(stack.pop()); 
                if (token.equals("+")) {
                    stack.push(String.valueOf(left + right));
                } else if (token.equals("-")) {
                    stack.push(String.valueOf(left - right));
                } else if (token.equals("*")) {
                    stack.push(String.valueOf(left * right));
                } else if (token.equals("/")) {
                    stack.push(String.valueOf(left / right));
                }
            }
        }
        if(stack.isEmpty()){
            result = 0;
        }else{
            result = Integer.valueOf(stack.pop());
        }
        return result;
    }
}

//two stack
public class Solution{
    public int evaluateExpression(String[] expression) {
        if(expression == null || expression.length == 0){// 空集情况
            return 0;
        }
        Stack<Integer> values = new Stack<Integer>();
        Stack<String> ops = new Stack<String>();
        for (int i = 0; i < expression.length; i++){
            if (expression[i].equals("(")){
                ops.push(expression[i]);
            }else if (expression[i].equals(")")){
                while (!ops.peek().equals("(")){
                    int right = values.pop();
                    int left = values.pop();
                    values.push(applyOp(ops.pop(), left, right));
                }
                ops.pop();
            }else if (expression[i].equals("+") || expression[i].equals("-") ||
                      expression[i].equals("*") || expression[i].equals("/")){
                while (!ops.empty() && hasPrecedence(expression[i], ops.peek())){
                    int right = values.pop();
                    int left = values.pop();
                    values.push(applyOp(ops.pop(), left, right));
                }
                ops.push(expression[i]);
            }else{
                values.push(Integer.parseInt(expression[i]));
            }
        }
        while (!ops.empty()){
            int right = values.pop();
            int left = values.pop();
            values.push(applyOp(ops.pop(), left, right));
        }
        if(values.isEmpty()){ //一堆括号的情况
            return 0;
        }
        return values.pop();
    }
    public boolean hasPrecedence(String now, String prev){ //判断当前的运算符是否有更高的优先级
        if (prev.equals("(") || prev.equals(")")){
            return false;
        }
        if ((now.equals("*") || now.equals("/")) && (prev.equals("+") || prev.equals("-"))){
            return false;
        }else{
            return true;
        }
    }
    public int applyOp(String op, int left, int right){
        if(op.equals("+")){
            return left + right;
        }else if(op.equals("-")){
            return left - right;
        }else if(op.equals("*")){
            return left * right;
        }else if(op.equals("/")){
            if(right == 0){
                return 0;
            }
            return left / right;
        }
        return 0;
    }
}



/*
Given an expression string array, return the final result of this expression
Notice
The expression contains only integer, +, -, *, /, (, ).
Example
For the expression 2*6-(23+7)/(1+2),
input is
[
  "2", "*", "6", "-", "(",
  "23", "+", "7", ")", "/",
  (", "1", "+", "2", ")"
],
return 2
Tags 
LintCode Copyright Stack
*/
