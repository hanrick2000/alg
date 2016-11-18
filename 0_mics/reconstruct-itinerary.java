public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> hashmap = new HashMap<String, PriorityQueue<String>>();
        List<String> list = new ArrayList<String>();
        String cur = "JFK";
        int length = tickets.length;
        for (int i = 0; i < length; i++) {
            if (!hashmap.containsKey(tickets[i][0])) {
                hashmap.put(tickets[i][0], new PriorityQueue<String>());
            }
            hashmap.get(tickets[i][0]).add(tickets[i][1]);
        }
        dfs(cur, hashmap, list);
        Collections.reverse(list);
        return list;
    }
    public void dfs(String cur, Map<String, PriorityQueue<String>> hashmap, List<String> list) {
        while (hashmap.containsKey(cur) && !hashmap.get(cur).isEmpty()) {
            dfs(hashmap.get(cur).poll(), hashmap, list);
        }
        list.add(cur);
    }
}
