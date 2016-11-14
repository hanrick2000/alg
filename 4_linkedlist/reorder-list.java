/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null){
            return;
        }
        ListNode mid = findMid(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);
    }
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    public void merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int index = 0;
        while(l1 != null && l2 != null){
            if(index % 2 == 0){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            index++;
        }
        if(l1 == null){
            tail.next = l2;
        }else{
            tail.next = l1;
        }
        l1 = dummy.next;
    }
}

Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
Example
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
Challenge 
Can you do this in-place without altering the nodes' values?
