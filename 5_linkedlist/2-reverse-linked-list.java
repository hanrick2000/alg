/*
Reverse a linked list.
Example
For linked list 1->2->3, the reversed linked list is 3->2->1
Challenge 
Reverse it in-place and in one-pass
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
*/
public class Solution {
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
