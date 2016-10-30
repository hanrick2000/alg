public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0){ 
            return null;
        }
        ListNode dummy = new ListNode(0); //忘了new标识符, dummy是个节点, next指向head
        dummy.next = head;
        ListNode preDelete = dummy; //preDelete只是一个指针, 指向某个节点
        for (int i = 0; i < n; i++){ 
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}

/*
Given a linked list, remove the nth node from the end of list and return its head.
The minimum number of nodes in list is n.
Example
Given linked list: 1->2->3->4->5->null, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5->null.
Challenge 
Can you do it without getting the length of the linked list?

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
*/ 
