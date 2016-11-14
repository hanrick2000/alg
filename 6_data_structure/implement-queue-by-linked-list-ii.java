class Node {
    public int val;
    public Node next, prev;
    public Node(int _val) {
        val = _val;
        prev = next = null;
    }
}

public class Dequeue {
    public Node first, last;
    
    public Dequeue() {
        first = last = null;
        // do initialize if necessary
    }

    public void push_front(int item) {
        // Write your code here
        if (first == null) {
            last = new Node(item);
            first = last;    
        } else {
            Node tmp = new Node(item);
            first.prev = tmp;
            tmp.next = first;
            first = first.prev;
        }
    }

    public void push_back(int item) {
        // Write your code here
        if (last == null) {
            last = new Node(item);
            first = last;    
        } else {
            Node tmp = new Node(item);
            last.next = tmp;
            tmp.prev = last;
            last = last.next;
        }
    }

    public int pop_front() {
        // Write your code here
        if (first != null) {
            int item = first.val;
            first = first.next;
            if (first != null)
                first.prev = null;
            else
                last = null;
            return item;
        }
        return -11;
    }

    public int pop_back() {
        // Write your code here
        if (last != null) {
            int item = last.val;
            last = last.prev;
            if (last != null)
                last.next = null;
            else
                first = null;
            return item;
        }
        return -11;
    }
}

Implement a Queue by linked list. Provide the following basic methods:

push_front(item). Add a new item to the front of queue.
push_back(item). Add a new item to the back of the queue.
pop_front(). Move the first item out of the queue, return it.
pop_back(). Move the last item out of the queue, return it.
Have you met this question in a real interview? Yes
Example
push_front(1)
push_back(2)
pop_back() // return 2
pop_back() // return 1
push_back(3)
push_back(4)
pop_front() // return 3
pop_front() // return 4
Tags 
Linked List Queue
