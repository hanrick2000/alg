/**
 * Definition for ListNode
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        HashSet<Integer> hash = new HashSet<Integer>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (hash.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                hash.add(head.next.val);
                head = head.next;
            }
        }
        
        return dummy.next;
    }  
}

Write code to remove duplicates from an unsorted linked list.

Have you met this question in a real interview? Yes
Example
Given 1->3->2->1->4.

Return 1->3->2->4

Challenge 
(hard) How would you solve this problem if a temporary buffer is not allowed? In this case, you don't need to keep the order of nodes.
