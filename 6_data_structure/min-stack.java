// version 1, 比version2能省一些空间, 但时间复杂度并没有变化
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()){
            minStack.push(number);
        }else{
            if (number <= minStack.peek()){
                minStack.push(number);
            }
        }
    }
    public int pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }
    public int min() {
        return minStack.peek();
    }
}

// version 2: 空间复杂度是O(2n), 同时记录下当前栈顶元素时的最小值是什么
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }
    public int pop() {
        minStack.pop();
        return stack.pop();
    }
    public int min() {
        return minStack.peek();
    }
}


/*
看到题目第一反应是用一个int minVal来记录整个stack当前的最小值就可以了
然后仔细想下, 发现问题在于当这个最小值被pop以后, 无法O(1)时间得到新的最小值
所以问题的关键在于要跟踪记录每个新数字压入栈时的当前最小值, 而不是只记录一个总的最小值

一种思路是将pair(cur, curMin)一起压入栈stack<pair<int,int>>中. 但这种方法的空间复杂度为2n. 这就是version1的思路
再仔细观察, 发现只有当push或pop的对象cur <= min(stack)时, 才会影响到min(stack)的值.
这就是会省一些空间的version2思路
用另一个minStack来记录min值的变化, minStack.peek()表示当前最小值.
当有新的cur<=minStack.peek()被压入时, 将cur压入minStack变为新的当前最小值.
当cur==minStack.peek()时被pop出时,minStack也同时pop.

这里的一个关键是理解为什么是x<=minStack.peek()而不是x<minStack.peek().
举个反例:如果按照只有当x<minStack.peek()时才push到栈中
压入以下数后:
stack:    3 2 1 2 1 
minStack: 3 2 1
此时如果pop,则变为
stack:    3 2 1 2
minStack: 3 2
然而实际栈里的最小值仍旧为1,这个1因为重复数字的关系在minStack中丢失.

Implement a stack with min() function, 
which will return the smallest number in the stack.
It should support push, pop and min operation all in O(1) cost.
Notice: min operation will never be called if there is no number in the stack.
Example
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1
Tags: Stack Zenefits Uber Google
*/
