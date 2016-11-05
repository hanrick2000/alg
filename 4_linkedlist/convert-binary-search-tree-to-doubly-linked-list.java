public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) { 
        if (root == null) {
            return null;
        }
        ResultType result = helper(root);
        return result.first;
    }
    public ResultType helper(TreeNode root) { //递归定义: 返回当前BST树的最小节点和最大节点
        if (root == null) {
            return null;
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        ResultType result = new ResultType(null, null);
        if (left == null) {
            result.first = node;
        } else {
            result.first = left.first;
            left.last.next = node; //把左子树和root用链表相连
            node.prev = left.last;
        }
        if (right == null) {
            result.last = node;
        } else {
            result.last = right.last;
            right.first.prev = node; //把右子树和root用链表相连
            node.next = right.first;
        }
        return result;
    }

    class ResultType {
        DoublyListNode first; //以当前root为跟的树, 最小值的node
        DoubleListNode last; //以当前root为跟的树, 最大值的node
        public ResultType(DoublyListNode first, DoublyListNode last) {
            this.first = first;
            this.last = last;
        }
    }
}

Convert a binary search tree to doubly linked list with in-order traversal.
Example
Given a binary search tree:
    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5

/*
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next;
 *     DoubleListNode prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 

//1101
public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if(root == null){
            return null;
        }
        ResultType node = helper(root);
        return node.first;
    }
    ResultType helper(TreeNode root){
        if(root == null){
            return null;
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node =  new DoublyListNode(root.val);
        ResultType result = new ResultType(null, null);
        if(left == null){
            result.first = node;
        }else{
            result.first = left.first;
            left.last.next = node
            node.prev = left.last;
        }
        if(right == null){
            result.right = node;
        }else{
            result.right = right.last;
            right.first.prev = node;
            node.next = right.first;
        }
        return result;
    }
    Class ResultType{
        DoublyListNode first;
        DoublyListNode last;
        public ResultType(DoublyListNode first, DoublyListNode last){
            this.first = first;
            this.last = last;
        }
    }
}
