public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
//node指向head, 如果node.next不为空, 那么判断下node的值和node.next的值是否相等, 相等就删掉node.next

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
//1031
class Solution{
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode node = head;
        while(node.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return head;
    }
}
*/
