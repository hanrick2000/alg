class Stack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public Stack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    public void push(int value) {
        queue1.offer(value);
    }
    public int top() {
        moveItems();
        int item = queue1.poll();
        swapQueues();
        queue1.offer(item);
        return item;
    }
    public void pop() {
        moveItems();
        queue1.poll();
        swapQueues();
    }
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    private void moveItems() { //把queue1的最后一个元素外移动到queue2中
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}

Implement a stack by two queues. The queue is first in first out (FIFO). 
That means you can not directly pop the last element in a queue.
Example
push(1)
pop()
push(2)
isEmpty() // return false
top() // return 2
pop()
isEmpty() // return true
Tags 
Stack Queue
