public class ThreeStacks {
    public int stackSize;
    public int indexUsed;
    public int[] stackPointer;
    public StackNode[] buffer;

    public ThreeStacks(int size) {
        // do intialization if necessary
        stackSize = size;
        stackPointer = new int[3];
        for (int i = 0; i < 3; ++i)
            stackPointer[i] = -1;
        indexUsed = 0;
        buffer = new StackNode[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        // Write your code here
        // Push value into stackNum stack
        int lastIndex = stackPointer[stackNum];
      stackPointer[stackNum] = indexUsed;
        indexUsed++;
        buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value, -1);
    }
    
    public int pop(int stackNum) {
        // Write your code here
        // Pop and return the top element from stackNum stack
        int value = buffer[stackPointer[stackNum]].value;
        int lastIndex = stackPointer[stackNum];
        if (lastIndex != indexUsed - 1)
            swap(lastIndex, indexUsed - 1, stackNum);

        stackPointer[stackNum] = buffer[stackPointer[stackNum]].prev;
        if (stackPointer[stackNum] != -1)
            buffer[stackPointer[stackNum]].next = -1;

        buffer[indexUsed-1] = null;
        indexUsed --;
        return value;
    }

    public int peek(int stackNum) {
        // Write your code here
        // Return the top element
        return buffer[stackPointer[stackNum]].value;
    }

    public boolean isEmpty(int stackNum) {
        // Write your code here
        return stackPointer[stackNum] == -1;
    }

    public void swap(int lastIndex, int topIndex, int stackNum) {
        if (buffer[lastIndex].prev == topIndex) {
            int tmp = buffer[lastIndex].value;
            buffer[lastIndex].value = buffer[topIndex].value;
            buffer[topIndex].value = tmp;
            int tp = buffer[topIndex].prev;
            if (tp != -1) {
                buffer[tp].next = lastIndex;
            }
            buffer[lastIndex].prev = tp;
            buffer[lastIndex].next = topIndex;
            buffer[topIndex].prev = lastIndex;
            buffer[topIndex].next = -1;
            stackPointer[stackNum] = topIndex;
            return;
        }

        int lp = buffer[lastIndex].prev;
        if (lp != -1)
            buffer[lp].next = topIndex;
        
        int tp = buffer[topIndex].prev;
        if (tp != -1)
            buffer[tp].next = lastIndex;

        int tn = buffer[topIndex].next;
        if (tn != -1)
            buffer[tn].prev = lastIndex;
        else {
            for (int i = 0; i < 3; ++i)
                if (stackPointer[i] == topIndex)
                    stackPointer[i] = lastIndex;
        }

        StackNode tmp = buffer[lastIndex];
        buffer[lastIndex] = buffer[topIndex];
        buffer[topIndex] = tmp;
        stackPointer[stackNum] = topIndex;
    }
}

class StackNode {
    public int prev, next;
    public int value;
    public StackNode(int p, int v, int n) {  
        value = v;
        prev = p;
        next = n;
    }
}

Implement three stacks by single array.

You can assume the three stacks has the same size and big enough, you don't need to care about how to extend it if one of the stack is full.

Have you met this question in a real interview? Yes
Example
ThreeStacks(5)  // create 3 stacks with size 5 in single array. stack index from 0 to 2
push(0, 10) // push 10 in the 1st stack.
push(0, 11)
push(1, 20) // push 20 in the 2nd stack.
push(1, 21)
pop(0) // return 11
pop(1) // return 21
peek(1) // return 20
push(2, 30)  // push 30 in the 3rd stack.
pop(2) // return 30
isEmpty(2) // return true
isEmpty(0) // return false
Tags 
Stack
