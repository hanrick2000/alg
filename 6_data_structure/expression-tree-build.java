//version new
public class Solution {
    class TreeNode {
        int val;
        ExpressionTreeNode eNode;
        public TreeNode(int val, String s) {
            this.val = val;
            eNode = new ExpressionTreeNode(s);
        }
    }
    public ExpressionTreeNode build(String[] expression) {
        if (expression == null || expression.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int base = 0;
        int val = 0;
        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                base += 10;
                continue;
            }
            if (expression[i].equals(")")) {
                base -= 10;
                continue;
            }
            val = getWeight(base, expression[i]);
            TreeNode node = new TreeNode(val, expression[i]);
            while (!stack.isEmpty() && node.val <= stack.peek().val) {
                node.eNode.left = stack.pop().eNode;
            }
            if (!stack.isEmpty()) {
                stack.peek().eNode.right = node.eNode;
            }
            stack.push(node);
        }
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode rst = stack.pop();
        while (!stack.isEmpty()) {
            rst = stack.pop();
        }
        return rst.eNode;
    }
    //Calculate weight for characters
    public int getWeight(int base, String s) {
        if (s.equals("+") || s.equals("-")) {
            return base + 1;
        }
        if (s.equals("*") || s.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }
}

class TreeNode { 
    public int val;
    public ExpressionTreeNode root; 
    public TreeNode(int val, String ss) {
        this.val = val; 
        this.root = new ExpressionTreeNode(ss);
    }
}
public class Solution {
    public ExpressionTreeNode build(String[] expression) {
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode root = null;
        int val = 0;
        Integer base = 0;
        for (int i = 0; i <= expression.length; i++) {
            if(i != expression.length){ 
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
                val = get(expression[i], base);
            }
            TreeNode right = null;
            if(i == expression.length){ 
              right = new TreeNode(Integer.MIN_VALUE, "");
            }else{
              right = new TreeNode(val, expression[i]);
            }
            while (!stack.isEmpty()) {
                if (stack.peek().val >= right.val) { 
                    TreeNode nodeNow = stack.pop();
                    if (stack.isEmpty()) {
                        right.root.left = nodeNow.root;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val < right.val) { //如果新的运算符优先级大于前一个运算符
                            right.root.left = nodeNow.root;
                        } else {
                            left.root.right = nodeNow.root;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().root.left;
    }
    int get(String a, Integer base) {
        if (a.equals("+") || a.equals("-"))
            return 1 + base;
        if (a.equals("*") || a.equals("/"))
            return 2 + base;
        return Integer.MAX_VALUE;
    }
}

//max-tree的优先级直接是由数组中的元素值决定的
//这题的优先级是表达式中的+-*/()和数字共同决定的
class TreeNode { //叫TreeNode, 实际是把ExpressionTreeNode包装一下, 加入表示优先级的val
    public int val;
    public ExpressionTreeNode root;  //
    public TreeNode(int val, String ss) {
        this.val = val; //用来存节点的优先级, 优先级决定了在min tree中的高度
        this.root = new ExpressionTreeNode(ss);
    }
}
public class Solution {
    public ExpressionTreeNode build(String[] expression) {
        Stack<TreeNode> stack = new Stack<TreeNode>(); //维护一个递增栈
        TreeNode root = null;
        int val = 0;
        Integer base = 0;
        for (int i = 0; i <= expression.length; i++) {
            if(i != expression.length){ //base计算优先级用
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
                val = get(expression[i], base);
            }
            TreeNode right = null;
            //这里的right表示右侧的运算符或者数字, left是左侧的运算符, 而非树的左右孩子
            if(i == expression.length){ //最后一个节点用MIN_VALUE把所有的栈中元素出栈
              right = new TreeNode(Integer.MIN_VALUE, "");
            }else{
              right = new TreeNode(val, expression[i]);
            }
            while (!stack.isEmpty()) {
                if (stack.peek().val >= right.val) { //不满足递增栈
                    //选递增栈的原因是优先处理高优先级的计算
                    TreeNode nodeNow = stack.pop();
                    if (stack.isEmpty()) {
                        //这行跟left.val < right.val时一样
                        right.root.left = nodeNow.root;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val < right.val) {
                        //但凡是right的优先级高, 则一定把nodeNow放到right的左子树, 因为right是新的节点
                        //表示right的优先级高于left的优先级
                        //即新加入运算符的优先级高于其前一个运算符的优先级
                        //根据left和right比较来决定把nodeNow放到哪里
                        //right是新加进来的节点, left是栈中nodeNow左边的元素
                        //因为right是不满足当前递增栈的元素, 
                        //能到这里, 一定是right.val < nodeNow.val(不满足递增栈)
                        //如果left.val < right.val, 
                        //则有 left.val < right.val < nodeNow.val
                        //执行到这里时, 下一步一定是把right放入stack了
                            right.root.left = nodeNow.root;
                        } else {
                        //如果left的优先级高, 那么因为他已经有了左孩子, 则要把nodeNow连到left右孩子
                        //新加入的运算符的优先级没有比前一个运算符的优先级高
                        //即老运算符的优先级>=新的运算符
                        //否则就是 right.val < left.val, 又 right.val < nodeNow.val
                        //切 left.val < nodeNow.val, 因为栈是递增的
                        //则有 right.val < left.val < nodeNow.val
                        //执行到这里时, 下一步还得要while中继续迭代
                            left.root.right = nodeNow.root;
                        }
                    }
                } else { //满足递增栈
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().root.left;
    }
    int get(String a, Integer base) {
        if (a.equals("+") || a.equals("-"))
            return 1 + base;
        if (a.equals("*") || a.equals("/"))
            return 2 + base;
        return Integer.MAX_VALUE;
    }
}


/*
观察example, 可以看出所有叶节点都为数字.
如果给每个元素赋予一个优先级, * 和 / 为2,  + 和 - 为1, 数字为极大值,
然后规定优先级越大的越在下, 越小的越在上. 
这样, 这道题就转化为构建Min Tree, 和之前的Max Tree做法类似, 只是这里维持的是一个递增栈.
同时, 当遇见"("时, 提高优先级, 遇见")"时, 降低优先级.

1 遍历数组, 给每个新来的元素赋予一个val值用以比较优先级. 
  * 和 / 为2， + 和 - 为1,  数字为极大值.
2 此时看栈顶元素(若栈为空则直接加入). 
  为了维持一个递增栈, 若栈顶元素比新来元素val大(或相等), 则出栈; 
  若栈顶元素比新来元素val小, 则break.
3 若2中栈顶元素出栈, 此时若栈为空, 则将出栈元素作为新来元素的左节点, 并将新来元素加入栈中; 
  若不为空, 看新栈顶元素, 若新栈顶元素比新来元素val小, 则将出栈元素作为新来元素的左孩子, 并将新来元素加入栈中; 
  若新栈顶元素比新来元素val大(或相等), 则将出栈元素作为新栈顶元素的右节点,

重复2-3,直到栈为空或者栈顶元素比新来元素要小,将新来元素加入栈中.
tips:在遍历万整个数组后,多加一个值,将其val赋值为极小,这样所有元素都会出栈并构建成完整的树.

The structure of Expression Tree is a binary tree to evaluate certain expressions.
All leaves of the Expression Tree have an number string value. 
All non-leaves of the Expression Tree have an operator string value.
Now, given an expression array, build the expression tree of this expression, 
return the root of this expression tree.
Clarification
See wiki: Expression Tree
Example
For the expression (2*6-(23+7)/(1+2)) 
["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]
The expression tree will be like
                 [ - ]
             /          \
        [ * ]              [ / ]
      /     \           /         \
    [ 2 ]  [ 6 ]      [ + ]        [ + ]
                     /    \       /      \
                   [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
After building the tree, you just need to return root node [-].
Tags: Stack, Binary Tree
public class ExpressionTreeNode {
    public String symbol;
    public ExpressionTreeNode left;
    public ExpressionTreeNode right;
    public ExpressionTreeNode(String symbol) {
        this.symbol = symbol;
    }
}

base=0
== (
base=10
== 2
right=(max,2)
stack=(max,2)
== *
right=(12,*)
    (12,*)
   /
(max,2)
stack=(12,*)
== 6
right=(max,6)
stack=(12,*) (max,6)
== - ********************
right=(11,-)
nodeNow=(max,6)
stack=(12,*)
left=(12,*)
    (12,*)
   /     \
(max,2)   (max,6)
nodeNow=(12,*)
stack=() empty
         (11,-)
        /
    (12,*)
   /     \
(max,2)   (max,6)
stack=(11,-)
== (
base=20
== 23
right=(max,23)
stack=(11,-) (max,23)
== +
right=(21,+)
stack=(11,-) (max,23)
nodeNow=(max,23)
stack=(11,-)
left=(11,-) peak()
left<right, 把nodeNow连接到right的左子树
    (21,+)
   /
(max,23)
当前的stack: (11,-)
把right让如到stack
stack=(11,-) (21,+)
== 7
right=(max,7)
stack=(11,-) (21,+)
stack=(11,-) (21,+) (max,7)
== )
base = 10
== /
right=(12,/)
当前的stack=(11,-) (21,+) (max,7)
从stack中pop()出一个 nodeNow=(max,7)
stack剩下(11,-) (21,+)
left=(21,+) stack的peak()
left>right, 这时要把nodeNow连接到left的右子树, nodeNow是个数字
     (21,+)
     /    \
 (max,23)  (max,7)
因为当前stack的peak是(21,+), 大于right(12,/), 还是不满足递增栈, 把栈顶取出来
nodeNow=(21,+)
stack=(11,-)
left=(11,-)

        (12,/)
       /
     (21,+)
     /    \
 (max,23)  (max,7)
stack=(11,-) (12,/)
== (
base=20
== 1
right=(max,1)
stack=(11,-) (12,/) (max,1)
== +
right=(21,+)
nodeNow=(max,1)
left=(12,/)
    (21,+)
   /
 (max,1)
stack=(11,-) (12,/) (21,+)
== 2
right=(max,2)
stack=(11,-) (12,/) (21,+) (max,2)
== )
base = 10
== )
base = 0
== min
right=(min,_)
nodeNow=(max,2)
left=(21,+)
     (21,+)
    /     \
  (max,1) (max,2)
nodeNow=(21,+)
left=(12,/)
       (12,/)
       /    \
      略    (21,+)
            /     \
          (max,1) (max,2)
nodeNow=(12,/)
left=(11,-)
         (11,-)
        /      \
       略       (12,/)
nodeNow=(11,-)
        (min,_)
        /
      (11,-)
最后return root.left

2+6-4和2+6*4
== right=2
stack=[2]
== right=+
  +
 /
2
stack=[+]
== right=6
stack=[+ 6]
== right=-
6出栈, 放到nodeNow中
看left=+
+和-的权重一样
    +
   / \
  2   6
     -
    / \
   +
  / \
 2   6
stack=[-]
== right=4
stack=[- 4]
== right=MIN_VALUE
nodeNow=4
left=-
left的优先级大于right
       -
      / \
     +   4
    / \
   2   6
stack=[-]
nodeNow=-
stack=[]
     MIN_VALUE
        /
       -
      / \
     +   4
    / \
   2   6
stack=[MIN_VALUE]


2+6*4
2
stack=[2]
  +
 /
2
stack=[+]
6
stack=[+ 6]
right=*
nodeNow=6
left=+
right的优先级大于left的优先级, 则把6连接到*的左孩子
   *
  /
 6
peek变成了+, +的优先级小于*, 则*入栈
stack=[+ *]
right=4
stack=[+ * 4]
right=MIN_VALUE
nodeNow=4, stack=[+ *]
left=*
*的优先级高, 把4连到*的右孩子
    *
   / \
  6   4
peek=*, peak>MIN_VALUE
nodeNow=*
left=+
      +
     / \
    2   *
       / \
      6   4
*/
