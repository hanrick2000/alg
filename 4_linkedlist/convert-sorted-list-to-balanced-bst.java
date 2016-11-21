public class Solution {
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        current = head;
        size = getListLength(head);
        return sortedListToBSTHelper(size);
    }
    public TreeNode sortedListToBSTHelper(int size) { //考虑size＝0和size=1, size=2时的情况, 递归定义: 返回长度是n的有序链表的BST树的树根
        if (size <= 0) {
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2); //size去掉已经处理的size/2和root
        root.left = left;
        root.right = right;
        return root;
    }
    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}

/*
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.

Example
               2
1->2->3  =>   / \
             1   3

1->2->3->4->5

      3
    /  \
   2    4
  /      \
 1        5

      3
    /  \
   1    4
    \    \
     2    5

      3
    /  \
   1     5
    \   / 
     2 4   
*/

/*
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 

/*
public class Solution {
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        int size = getLength(head);
        current = head;
        return sortedListToBSTHelper(size);
    }
    public TreeNode sortedListToBSTHelper(int size){
        if(size <= 0){
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }
    public int getLength(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}
*/
