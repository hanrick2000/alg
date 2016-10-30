/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        return reverse(addList1(l1, l2));
    }  
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private ListNode addList1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            tail.next = new ListNode((l1.val + l2.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + l2.val + carry) / 10;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            tail.next = new ListNode((l1.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + carry) / 10;
            
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            tail = tail.next;
            carry = (l2.val + carry) / 10;
            
            l2 = l2.next;
        }
        
        while (carry != 0) {
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry = carry / 10;
        }
        
        return dummy.next;
    }
}

You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in forward order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Have you met this question in a real interview? Yes
Example
Given 6->1->7 + 2->9->5. That is, 617 + 295.

Return 9->1->2. That is, 912.
