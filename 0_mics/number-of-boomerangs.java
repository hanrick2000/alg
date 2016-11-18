public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j){
                    continue;
                }
                int d = getDistance(points[i], points[j]);                
                map.put(d, map.getOrDefault(d, 0) + 1); //getOrDefault是java8的特性
                //map中存的是与i点距离是d的点的个数
            }
            for(int val : map.values()) {
                res += val * (val - 1);
            }            
            map.clear();
        }
        return res;
    }
    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}

/*
比如与i点
距离是1的有2个
距离是2的有3个
距离是3的有4个
那么以i点为中心的boomerangs的个数就是: 


Time complexity:  O(n^2)
Space complexity: O(n)
*/

/*
Given n points in the plane that are all pairwise distinct, 
a "boomerang" is a tuple of points (i, j, k) 
such that the distance between i and j equals 
the distance between i and k (the order of the tuple matters, 这里表示顺序不同算多种).
Find the number of boomerangs. 
You may assume that n will be at most 500 
and coordinates of points are all in the range [-10000, 10000] (inclusive).
Example:
Input:
[[0,0],[1,0],[2,0]]
Output:
2
Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
Company Tags Google
Tags Hash Table
Similar Problems (M) Line Reflection
*/
