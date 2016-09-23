//Medium
/*
Given a binary search tree (See Definition) and a node in it, 
find the in-order successor of that node in the BST.
If the given node has no in-order successor in the tree, return null.
It's guaranteed p is one node in the given tree. 
(You can directly compare the memory address to find p)
Example
Given tree = [2,1] and node = 1:
  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:
  2
 / \
1   3
return node 3.
*/
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root != p) { //退出循环的条件是root==p, 或者一上来root就是null, 关键点就是根据BST找到这个p, 如果这个p有successor, 这个successor只在root右儿子不存在时有用, 如果右儿子存在那么还要在有儿子中找到最左下的儿子
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) { //root是null
            return null;
        }
        if (root.right == null) { //到这里时root就是p, 如果root的右孩子是null, 那么直接返回successor
            return successor;
        }
        root = root.right; //到这里说明root，有右孩子, 则找到右孩子的最左孩子就是root的in-order successor
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
/*
p=2 get null
   2
  /
 1
*/

/*
p=2, get 3
p=3, get 4
p=1, get 1
p=4, get 5
p=5, get null
    2
  /  \
1     3
       \
        5
       /
      4
*/
