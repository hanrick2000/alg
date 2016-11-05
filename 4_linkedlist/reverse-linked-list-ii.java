public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = nNode.next;
        for (int i = m; i < n; i++) { //对比reverse-linked-list-i, postnNode相当于head, nNode相当于preNode
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        return dummy.next;
    }
}
//用dummy指针指向head的前面, head移动到dummy位置, 先走到m的前面, premNode是m前一个, mNode,nNode指向m, postnNode是m的下一个, 翻转n-m次

/*
Reverse a linked list from position m to n.
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
Challenge 
Reverse it in-place and in one-pass
*/
      3      6
      m      n
O-O---O-O--O-O---O--O
  pm  m           
      n pn

O-O---O-O--O-O---O--O
  pm  m      n   pn


//1031, m>=n时return head; 开始时从1到m-1; 别忘了判断postnNode == null
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m >= n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for(int i = 1; i < m; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = nNode.next;
        for(int i = m; i < n; i++){
            if(postnNode == null){
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp; 
        }
        premNode.next = nNode;
        mNode.next = postNnode;
        return dummy.next;
    }
}

