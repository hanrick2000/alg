// Merge Sort
public class Solution {            
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }
}

// Quick Sort
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMedian(head); // O(n)
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0);
        ListNode middleTail = middleDummy;
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = head;
            } else if (head.val == mid.val) {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        return concat(left, middleDummy.next, right);
    }
    private ListNode findMedian(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = left; 
        tail = getTail(tail);
        tail.next = middle; 
        tail = getTail(tail);
        tail.next = right; 
        tail = getTail(tail);
        return dummy.next;
    }
    private ListNode getTail(ListNode head) {
        if (head == null) {
           return null;
        } 
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}


Sort a linked list in O(n log n) time using constant space complexity.
Example
Given 1->3->2->null, sort it to 1->2->3->null.
Challenge 
Solve it by merge sort & quick sort separately.
