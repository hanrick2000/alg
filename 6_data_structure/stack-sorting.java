public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> tmp = new Stack<Integer>();
        while (!stack.isEmpty()) {
            if (!stack.isEmpty() && (tmp.isEmpty() || tmp.peek() >= stack.peek())) {
                tmp.push(stack.peek());
                stack.pop();
            }
            else {
                int value = stack.peek(); stack.pop();
                while (!tmp.isEmpty() && tmp.peek() <= value)  {
                    stack.push(tmp.peek());
                    tmp.pop();
                }
                stack.push(value);
                while (!tmp.isEmpty()) {
                    stack.push(tmp.peek());
                    tmp.pop();
                }
            }
        }
        while (!tmp.isEmpty()) {
            stack.push(tmp.peek());
            tmp.pop();
        }
    }
}

Sort a stack in ascending order (with biggest terms on top).

You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure (e.g. array).

Have you met this question in a real interview? Yes
Example
Given stack =

| |
|3|
|1|
|2|
|4|
 -
return:

| |
|4|
|3|
|2|
|1|
 -
The data will be serialized to [4,2,1,3]. The last element is the element on the top of the stack.

Challenge 
O(n^2) time is acceptable.

Tags 
Stack
