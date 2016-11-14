class Stack {
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        array.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        int n = array.size();
        if (n > 0)
            array.remove(n-1);
        return;
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        int n = array.size();
        return array.get(n-1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return array.size() == 0;
    }

    private List<Integer> array = new ArrayList<Integer>();
}

Implement a stack. You can use any data structure inside a stack except stack itself to implement it.

Have you met this question in a real interview? Yes
Example
push(1)
pop()
push(2)
top()  // return 2
pop()
isEmpty() // return true
push(3)
isEmpty() // return false
Tags 
Array Stack
