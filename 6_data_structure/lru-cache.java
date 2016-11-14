public class Solution {
    private class Node{ //双向链表
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>(); //map
    private Node head = new Node(-1, -1); //dummy, 其next指向lru
    private Node tail = new Node(-1, -1); //dummy, 其prev指向最近使用的node的
    
    public Solution(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public void set(int key, int value) {
        if(get(key) != -1) { //值存在时直接更新
            map.get(key).value = value;
            return;
        }
        if(map.size() == capacity) { //满了时先移除lru
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        move_to_tail(insert);
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        // remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        // move current to tail
        move_to_tail(current);
        return map.get(key).value;
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Tags 
Linked List, Zenefits, Uber, Google

用HashMap来存key和和其对应的node, 便于之后检索key是否已经存在.
用双向链表,便于操作数组中间的元素移动和删除.
get():如果key不存在, 则返回-1;
      如果key存在, 则将该key对应的node移到链表尾部.
set():如果key存在, 则将修改过value的该key对应node移到链表尾部;
      如果key不存在, 分两种情况:1)若chache已经达到其capacity, 则删去链表第一个node（least recently used item）,再加入该key的node;
                                2)若chache还没达到其capacity, 则在链表尾部加入该key的node.
