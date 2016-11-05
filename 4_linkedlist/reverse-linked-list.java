public class Solution {
    public ListNode reverse(ListNode head) {
        ListNode preNode = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = preNode;
            preNode= head;
            head = temp;
        }
        return preNode;
    }
}

//开始时preNode是null, 只要head不是null, 就先用tmp保存head的下一个, 让head指向preNode, 然后把preNode移动到head位置, head移动到tmp(临时存在tmp中)

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

//1031
public class Solution {
    public ListNode reverse(ListNode head) {
        ListNode preNode = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }
        return preNode;
    }
}
