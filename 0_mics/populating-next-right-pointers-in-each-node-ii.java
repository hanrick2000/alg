public class Solution {
    //based on level order traversal
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null; //下一层的作为head的节点, 需要单独记录下一层的head在哪里
        TreeLinkNode tail = null; //下一层的tail节点, tail总是指向当前行的末尾节点
        TreeLinkNode cur = root;  //当前层正在处理的节点
        while (cur != null) {
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (tail != null) {
                        tail.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    tail = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (tail != null) {
                        tail.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    tail = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            //move to next level
            cur = head;
            head = null;
            tail = null;
        }
    }
}
/*
Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? 
Would your previous solution still work?
Note:
You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
Company Tags Microsoft Bloomberg Facebook
Tags Tree Depth-first Search
Similar Problems (M) Populating Next Right Pointers in Each Node
*/
