public class Solution {
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findNodeParent(dummy, root, value);  //先找到要删除的点的parent
        TreeNode node;
        if (parent.left != null && parent.left.val == value) { //确定下deleted note是哪个
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left; //左右子树都没有node节点
        }
        deleteNode(parent, node); //开始删除, 做相应的变换
        return dummy.left;
    }
    private TreeNode findNodeParent(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNodeParent(node, node.left, value);
        } else {
            return findNodeParent(node, node.right, value);
        }
    }
    private void deleteNode(TreeNode parent, TreeNode node){
        if(node.right == null && node.left == null){ //第一种情况: node左右子树都是空
            parent.left = null;
            parent.right = null;
        }
        if(node.right == null && node.left != null){ //第二种情况: node只有一棵树空
            if(parent.left == node){
                parent.left = node.left;
            }else if(parent.right == node){
                parent.right = node.left;
            }
        }
        if(node.right != null && node.left == null){
            if(parent.left == node){
                parent.left = node.right;
            }else if(parent.right == node){
                parent.right = node.right;
            }
        }
        if(node.right != null && node.left != null){ //第三种情况: node两棵子树都不为空
            TreeNode temp = node.right;
            TreeNode father = node;
            while(temp.left != null){
                father = temp;
                temp = temp.left;
            }
            if(father.left == temp){ //因为要用temp替换node, 所以要把temp的右儿子接到其father上, 这里是右儿子因为temp已经是遍历到最左叶子了
                father.left = temp.right;
            }else if(father.right == temp){
                father.right = temp.right;
            }
            if(parent.left == node){ //用temp替换node
                parent.left = temp;
            }else if(parent.right == node){
                parent.right = temp;
            }
            temp.left = node.left; //把原来node儿子接给temp
            temp.right = node.right;
        }
    }
}

     5 parent
   /   \
  4     10  要删除10, 情况father.left == temp
 /    /   \
2   8      12 father
   /  \   /  \
  7    9 11   13
        temp

     5 parent
   /   \
  4     10 father  要删除10, 情况father.right == temp
 /    /   \
2   8      12  temp
   /  \      \
  7    9      13


Given a root of Binary Search Tree with unique value for each node. 
Remove the node with given value. 
If there is no such a node with given value in the binary search tree, do nothing. 
You should keep the tree still a binary search tree after removal.

Example
Given binary search tree:

    5
   / \
  3   6
 / \
2   4
Remove 3, you can either return:

    5
   / \
  2   6
   \
    4
or

    5
   / \
  4   6
 /
2

========  第一种情况, 删除10
    5
   / \
  4   10
 /    / 
2    8   
   /  \
  7    9

=======  第二种情况
     5
   /   \
  4     10 
 /    /   \
2   8      12
   /  \   /  \
  7    9 11   13

======= 第三种情况

    5
   / \
  4   10
 /     
2       

Delete node 有三种情况
因为要delete,在find这个node的过程中要保留一个parent的变量
1 Leaf node
  删掉这个node，把parent对这个node的reference设为null
2 Node with only one child
  delete the node,把parent对node的reference link到node的child
3 Node with 2 children
  find the minimum node of right subtree(the successor of deleted node)
  replace the value of deleted node
  delete the old duplicate node(transfer problem to case 1/2, cause minimum node should not have left child) 

Ref:
http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     

