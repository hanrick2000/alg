public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        n = n % length;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
}

/*
Given a list, rotate the list to the right by k places, where k is non-negative.
Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.

Dummy->1->2->3->4->5-N
head
tail

Dummy->1->2->3->4->5-N
  |       |
  |      head
tail

Dummy->1->2->3->4->5-N
             |     |
             |   head
            tail

       |--------------
       v             ^
Dummy->1->2->3->4->5-|
             |     |
             |    head
            tail

       |-------------|
       v             ^
Dummy->1->2->3->4->5-|
  |             ^  head
  |             |
  |--------------
            tail

       |-------------|
       v             ^
Dummy->1->2->3  4->5-|
  |             ^  head
  |             |
  |--------------
            tail
*/


//1031 注意while中是head.next != null
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int length = getLength(head);
        n = n % length;
        ListNote dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = head;
        for(int i = 0; i < n; i++){
            head = head.next; 
        }
        while(head.next != null){
            head = head.next;
            tail = tail.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    public int getLength(ListNode head){
        int length = 0;
        if(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}

