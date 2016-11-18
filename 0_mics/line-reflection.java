public class Solution {
    public boolean isReflected(int[][] points) {
        int max = 0, min = 0;
        HashMap<Integer, HashSet<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            max = Math.max(points[i][0], max);
            min = Math.min(points[i][0], min);
            if (!hashmap.containsKey(points[i][1])) {
                HashSet<Integer> hashset = new HashSet<>();
                hashset.add(points[i][0]);
                hashmap.put(points[i][1], hashset);
            } else {
                hashmap.get(points[i][1]).add(points[i][0]);
            }
        }
        for (int i = 0; i < points.length; i++) {
            if (!hashmap.containsKey(points[i][1]) || !hashmap.get(points[i][1]).contains(max + min - points[i][0])) {
                return false;
            }
        }
        return true;
    }
}
