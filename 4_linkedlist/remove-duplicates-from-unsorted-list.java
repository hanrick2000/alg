public class Solution {
    public ListNode removeDuplicates(ListNode head) { 
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (set.contains(head.next.val)) {
               head.next = head.next.next;
            } else {
                set.add(head.next.val);
                head = head.next;
            }
        }
        return dummy.next;
    }  
}

/*
Write code to remove duplicates from an unsorted linked list.
Example
Given 1->3->2->1->4.
Return 1->3->2->4
Challenge 
(hard) How would you solve this problem if a temporary buffer is not allowed? 
In this case, you don't need to keep the order of nodes.
*/


//1031: 注意set.add()
public class Solution {
    public ListNode removeDuplicates(ListNode head) { 
        if(head == null){
            return head;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null){
            if(set.contains(head.next.val)){
                head.next = head.next.next;
            }else{
                set.add(head.next.val);
                head = head.next;
            }
        }
        return dummy.next;
    }
}
