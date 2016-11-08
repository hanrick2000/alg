public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head); //找到中点
        ListNode tail = reverse(mid.next); //后半截逆序
        mid.next = null; //断开
        merge(head, tail); //合并
    }
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    private void merge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index ++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}


Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
Example
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
Challenge 
Can you do this in-place without altering the nodes' values?
