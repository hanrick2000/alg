public class Solution {
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        } 
        int len = nums.length;
        if(len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len + 1];
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(sums[i - 1].sum + nums[i - 1], i);
        }
        Arrays.sort(sums, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        return res;
    }
    class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }
}

/*
Given an integer array, 
find a subarray with sum closest to zero. 
Return the indexes of the first number and last number.
Example
        0  1  2   3  4
Given [-3, 1, 1, -3, 5], 
return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
sum     -1     -1       1       1         1
Challenge 
O(nlogn) time

0  -> 0
-3 -> 1
-2 -> 2
-1 -> 3
-4 -> 4
1  -> 5

-4 -> 4
-3 -> 1 1 temp={0, 3} -> res={1, 3}
-2 -> 2 1 temp={0, 1} -> res={1, 1}
-1 -> 3 1 temp={1, 2} -> res={2, 2}
0  -> 0 1 temp={-1,2} -> res={0, 2}
1  -> 5 1 temp={-1,4} -> res={0, 4}

*/
