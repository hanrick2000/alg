// Divide Conquer 
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2; 
        //divide
        ListNode left = mergeHelper(lists, start, mid); //分治到最底端只剩一个元素, 然后开始向上合并
        ListNode right = mergeHelper(lists, mid + 1, end);
        //conquer
        return mergeTwoLists(left, right);
    }
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }
}

// Merge lists two by two
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }
        while(lists.size() > 1){
            List<ListNode> tmpLists = new ArrayList<ListNode>();
            for(int i = 0; i < lists.size() - 1; i += 2){
                ListNode list = merge(lists.get(i), lists.get(i + 1));
                tmpLists.add(list);
            }
            if(lists.size() % 2 == 1){
                tmpLists.add(lists.get(lists.size() - 1));
            }
            lists = tmpLists;
        }
        return lists.get(0);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 == null){
            tail.next = l2;
        }else{
            tail.next = l1;
        }
        return dummy.next;
    }
}


// Priority Queue (Heap) 
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator); //PQ用法, 初始化指定大小, 以及元素的comparator
        for (int i = 0; i < lists.size(); i++) { //先把k路链表的头放入min-heap中
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll(); //PQ出堆, 然后放入下一个元素
            tail.next = head; //把出堆元素连接到结果list中
            tail = tail.next;
            if (head.next != null) {//如果还有元素没有遍历, 继续放入heap中
                heap.add(head.next);
            }
        }
        return dummy.next;
    }
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() { //Min heap
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
}


Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.
Example
Given lists:
[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.
