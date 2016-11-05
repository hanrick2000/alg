public class Solution {
    public ListNode middleNode(ListNode head) { 
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

Find the middle node of a linked list.
Example
Given 1->2->3, return the node with value 2.
Given 1->2, return the node with value 1.

O-O-O-O-O-O
s f
O-O-O-O-O-O
  s   f
O-O-O-O-O-O
    s     f

O-O-O-O-O
s f
O-O-O-O-O
  s   f
O-O-O-O-O
    s   f
         
//1031, while循环条件是(fast != null && fast.next != null)
public class Solution {
    public ListNode middleNode(ListNode head) { 
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}




















