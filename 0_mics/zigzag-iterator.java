public class ZigzagIterator {
    
    public Iterator<Integer> it1;
    public Iterator<Integer> it2;
    public int turns;

    /**
     * @param v1 v2 two 1d vectors
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        this.it1 = v1.iterator();
        this.it2 = v2.iterator();
        turns = 0;
    }

    public int next() {
        // Write your code here
        turns++;
        if((turns % 2 == 1 && it1.hasNext()) || (!it2.hasNext())) {
            return it1.next();
        } else if((turns % 2 == 0 && it2.hasNext()) || (!it1.hasNext())) {
            return it2.next();
        }
        return -1;  
    }

    public boolean hasNext() {
        // Write your code here
        return it1.hasNext() || it2.hasNext();        
    }
}
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */

Given two 1d vectors, implement an iterator to return their elements alternately.

Have you met this question in a real interview? Yes
Example
Given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
Tags 
Google
