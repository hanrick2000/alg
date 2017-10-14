public class Solution {
    public TreeNode maxTree(int[] A) {
        if(A == null || A.length == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for(int i = 0; i < A.length; i++){
            TreeNode node = new TreeNode(A[i]);
            while(!stack.isEmpty() && node.val >= stack.peek().val){
                node.left = stack.pop();
            }
            if(!stack.isEmpty()){
                stack.peek().right = node;
            }
            stack.push(node);
        }
        if(stack.isEmpty()){
            return null;
        }
        TreeNode root = stack.pop();
        while(!stack.isEmpty()){
            root = stack.pop();
        }
        return root;
    }
}


public class Solution {
    public TreeNode maxTree(int[] A) {
        if(A == null || A.length == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();//构造一个单调递减栈, 其中存的都是左子树
        for(int i = 0; i <= A.length; i++){
            TreeNode right = null;
            if(i == A.length){
              right = new TreeNode(Integer.MAX_VALUE);
            }else{
              right = new TreeNode(A[i]);
            }
            while (!stack.isEmpty()){
                if(stack.peek().val <= right.val){ //要保证递减栈, 如果新元素大于栈顶, 则需要调整, 否则加入
                    TreeNode nodeNow = stack.pop();
                    if(stack.isEmpty()){
                        right.left = nodeNow;
                    }else{
                        TreeNode left = stack.peek();
                        if(left.val > right.val){ //当弹出一个元素后, 新的栈顶大于新来元素时, 只需要把弹出的元素作为新元素的左孩子, 然后下一轮while时一定会退出, 新元素入栈, 保持递增栈, 栈中的元素如果有孩子, 则只会有左孩子
                            //nodeNow < right, left > right, left > nodeNow
                            //left > right > nodeNow
                            right.left = nodeNow;
                        }else{
                            //nodeNow < right, left < right, left > nodeNow
                            //right > left > nodeNow
                            left.right = nodeNow;
                        }
                    }
                }else{
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().left;
    }
}

/*
stack=()
== 2
stack=(2)
== 5
5 > 2
nodeNow = 2
stack=()
把2作为5的左孩子
   5
  /
 2
因为stack是空的了,把5放入stack, stack=(5)
== 6
6 > 5
nodeNow = 5
stack=()
把5作为6的左孩子
     6
    /
   5
  /
 2
因为stack是空的了, 把6放入stack, stack=(6)
== 0
0小于6
直接放入stack, stack=(6,0)
== 3
3大于0
把0取出来, stack剩下

*/

/*
本题其实是构建笛卡树(Cartesian tree, https://en.wikipedia.org/wiki/Cartesian_tree ),
经典方法是用单调栈(单调递减栈). 
我们栈里存放的树, 只有左子树(是这课树只有左孩子, 要不就没有孩子, 没有孩子的一定是数字, 只要是运算符一定有左孩子), 没有右子树, 且根节点最大. 时间复杂度为O(n).
1 如果新来一个数, 比栈顶的树根的数小, 则把这个数作为一个单独的节点压入栈.
2 如果新来的数比栈顶元素大, 不断从栈里弹出树, 新弹出的树用旧弹出的树为右子树, 连接起来, 
  直到目前栈顶的树根的数大于新来的数. 然后, 弹出的那些数, 已经形成了一个新的树, 
  这个树作为新节点的左子树, 把这个新树压入栈.
这样的栈是单调的, 越靠近栈顶的数越小.
最后, 用一个虚拟节点MAX_VALUE, 还要按照(2)的方法,把所有树弹出来, 每个旧树作为新树的右子树.
最终把栈顶的左孩子返回

如果用递归的方法建树, 时间复杂度会退化到O(n^2).

Given an integer array with no duplicates. 
A max tree building on this array is defined as follow:
The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
Example
Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
    6
   / \
  5   3
 /   / \
2   0   1
Challenge 
O(n) time and memory.
Tags 
LintCode Copyright Stack Cartesian Tree
Definition of TreeNode:
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

== 2
stack 2
== 5
   5
  /
 2
stack 5
== 6
    6
   /
  5
 /
2
stack 6
== 0
    6
   / \
  5   0
 /
2
stack 6 0
== 3
   3
  /
 0
stack 6
    6
   / \
  5   3
 /   /
2   0
stack 6 3
== 1
    6
   / \
  5   3
 /   / \
2   0   1
stack 6 3 1

[3,2,1,6,5,4,9,8,7]
== 3
stack 3
== 2
3
 \
  2
stack 3 2
== 1
3
 \
  2
   \
    1
stack 3 2 1
== 6
  6
 /
1
  6
 /
2
 \
  1
  6
 /
3
 \
  2
   \
    1
== 5
stack 6
  6
 / \
3   5
 \
  2
   \
    1
stack 6 5
== 4
  6
 / \
3   5
 \   \
  2   4
   \
    1
stack 6 5 4
== 9
  9
 /
4
  9
 /
5
 \
  4
    9
   /
  6
 / \
3   5
 \   \
  2   4
   \
    1
stack 9
== 8
    9
   / \
  6   8
 / \
3   5
 \   \
  2   4
   \
    1
stack 9 8
== 7
    9
   / \
  6   8
 / \   \
3   5   7
 \   \
  2   4
   \
    1






*/
