//注意这里是通过一个最小堆来维护最大的k个元素, 堆顶是最小元素, 要更新也是先更新最小元素
public class Solution {
    private int maxSize;
    private Queue<Integer> minheap;
    public Solution(int k) {
        minheap = new PriorityQueue<>();
        maxSize = k;
    }
    public void add(int num) {
        if (minheap.size() < maxSize) {
            minheap.offer(num);
            return;
        }
        if (num > minheap.peek()) {
            minheap.poll();
            minheap.offer(num);
        }
    }
    public List<Integer> topk() {
        Iterator<Integer> it = minheap.iterator();
        List<Integer> result = new ArrayList<Integer>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}

/*
Implement a data structure, provide two interfaces:

1 add(number). Add a new number in the data structure.
2 topk(). Return the top k largest numbers in this data structure. 
  k is given when we create the data structure.

Example
s = new Solution(3);
>> create a new data structure.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]
Tags 
Heap Priority Queue
*/
