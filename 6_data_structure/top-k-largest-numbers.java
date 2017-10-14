//维护一个k大小的最小堆, 遍历数组, 只有比堆顶元素大的才更新堆, 这样省空间和时间
class Solution{
    public int[] topk(int[] nums, int k){
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums){
            if(minHeap.size() < k){
                minHeap.offer(i);
            }else if(i > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(i);
            }
        }
        int[] result = new int[k];
        int i = k - 1;
        while(i >= 0){
            result[i] = minHeap.poll();
            i--;
        }
        return result;
    }
}

//这里是先把所有元素放入max heap, 然后取k个元素
class Solution {
     public int[] topk(int[] nums, int k) {
         //我们需要max heap, PriorityQueue默认是min heap
         Comparator<Integer> comparator = new Comparator<Integer>() {
             public int compare(Integer o1, Integer o2) {
                 if(o1 < o2) {
                     return 1;
                 } else if(o1 > o2) {
                     return -1;
                 } else {
                     return 0;
                 }
             }
         };
         PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, comparator);
         //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
         for (int i : nums) {
             maxHeap.add(i);
         }
         int[] result = new int[k];
         for (int i = 0; i < result.length; i++) {
             result[i] = maxHeap.poll();
         }
         return result;
    }
}


/*
Given an integer array, find the top k largest numbers in it.
Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].
Tags: Heap, Priority Queue
*/
