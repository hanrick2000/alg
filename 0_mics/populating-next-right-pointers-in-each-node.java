/*
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root; //head表示这一层的开始
        while(head != null){
            TreeLinkNode cur = head;
            while(cur != null){
                if(cur.left != null){
                    cur.left.next = cur.right;
                }
                if(cur.right != null && cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            head = head.left; //每次都是从最左边孩子开始
        }
    }
}

/*
Given a binary tree
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Note:
1 You may only use constant extra space.
2 You may assume that it is a perfect binary tree 
(ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
Company Tags Microsoft
Tags Tree Depth-first Search
Similar Problems (H) Populating Next Right Pointers in Each Node II 
                 (M) Binary Tree Right Side View
*/
