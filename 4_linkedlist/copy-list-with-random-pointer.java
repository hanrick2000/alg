public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) { //head.next是clone出的节点
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private RandomListNode splitList(RandomListNode head) { //跟partition list类似的过程
        RandomListNode dummyOld = new RandomListNode(0);
        RandomListNode dummyNew = new RandomListNode(0);
        RandomListNode oldTail = dummyOld;
        RandomListNode newTail = dummyNew;
        while(head != null){
            oldTail.next = head;
            newTail.next = head.next;
            oldTail = oldTail.next;
            newTail = newTail.next;
            head = head.next.next;
        }
        oldTail.next = null;
        head = dummyOld.next;
        return dummyNew.next;
    }
}
/*
No HashMap version
第一遍扫的时候巧妙运用next指针，开始数组是1->2->3->4 。 
然后扫描过程中先建立copy节点 1->1`->2->2`->3->3`->4->4`, 
然后第二遍copy的时候去建立random的copy， 
最后一遍,拆分节点, 一边扫描一边拆成两个链表，
这里用到两个dummy node。
第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`  
*/


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;
        while (head != null) {
            if (map.containsKey(head)) { //map里面有head就取出来
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);//map里面没有head就新建一个node, 并放入map
                map.put(head, newNode);
            }
            pre.next = newNode; 
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random); //random有就连过去
                } else {
                    newNode.random = new RandomListNode(head.random.label); //没有的话就新建一个连过去, 并放入map
                    map.put(head.random, newNode.random);
                }
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }
}


A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.
Return a deep copy of the list.
Example
Challenge 
Could you solve it with O(1) space?

/*
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next;
 *     RandomListNode random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

//1101
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        copyNode(head);
        copyRandom(head);
        return splitNode(head);
    }
    public void copyNode(RandomListNode head){
        while(head != null){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    public void copyRandom(RandomListNode head){
        while(head != null){
            if(head.next.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    public RandomListNode splitNode(RandomListNode head){
        RandomListNode newHead = head.next;
        while(head != null){
            RandomListNode temp = head.next;
            head.next = head.next.next;
            head = head.next;
            if(temp.next != null){
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }
}


