//简单方法是都放入min heap中, O(nlogn)
//这里是O(nlogk)的方法, 维护大小是k的min heap
public class Solution {
    class Element {
        public int row;
        public int col;
        public int val;
        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }
        int total_size = 0;
        Comparator<Element> ElementComparator = new Comparator<Element>() {
            public int compare(Element left, Element right) {
                return left.val - right.val;
            }
        };
        Queue<Element> Q = new PriorityQueue<Element>(arrays.length, ElementComparator);
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element elem = new Element(i, 0, arrays[i][0]);
                Q.add(elem);
                total_size += arrays[i].length;
            }
        }
        int[] result = new int[total_size];
        int index = 0;
        while (!Q.isEmpty()) {
            Element elem = Q.poll();
            result[index++] = elem.val;
            if (elem.col + 1 < arrays[elem.row].length) {
                //如果从堆里取出来的元素所在的原数组还有剩余元素, 继续放入堆中
                elem.col += 1;
                elem.val = arrays[elem.row][elem.col];
                Q.add(elem);
            }
        }
        return result;
    }
}

/*
Given k sorted integer arrays, merge them into one sorted array.
Example
Given 3 sorted arrays:
[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Challenge 
Do it in O(Nlogk).
N is the total number of integers.
k is the number of arrays.
Tags: Heap Priority Queue
*/
