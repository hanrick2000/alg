public class Solution {
    public List<List<String>> findLadders(String start, 
                                          String end, 
                                          Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>(); 
        //map内记录作为key的单词, 可以由哪些单词经过一步变换得到
        Map<String, Integer> distance = new HashMap<String, Integer>(); 
        //distance记录作为key的单词距离start的最短距离
        dict.add(start);
        dict.add(end);
        bfs(map, distance, start, end, dict);
        List<String> path = new ArrayList<String>();
        dfs(ladders, path, end, start, distance, map);
        return ladders;
    }
    void bfs(Map<String, List<String>> map, 
             Map<String, Integer> distance,
             String start, 
             String end, 
             Set<String> dict) { //用于求map和distance
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start); //BFS用到queue
        distance.put(start, 0);
        for (String s : dict) { //初始化map
            map.put(s, new ArrayList<String>());
        }
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String nextWord: getNextWords(word, dict)) {
                map.get(nextWord).add(word);
                if (!distance.containsKey(nextWord)) { 
                    //先放进distance的一定是这个单词到达start最短的距离
                    distance.put(nextWord, distance.get(word) + 1);
                    queue.offer(nextWord);
                }
            }
        }
    }
    void dfs(List<List<String>> ladders, 
             List<String> path, 
             String word, 
             String start, 
             Map<String, Integer> distance,
             Map<String, List<String>> map) {
        path.add(word);
        if (word.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String nextWord : map.get(word)) {
                if (distance.containsKey(nextWord) && 
                    distance.get(word) == distance.get(nextWord) + 1) { 
                    dfs(ladders, path, nextWord, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }
    private ArrayList<String> getNextWords(String word, Set<String> dict) { 
        //返回在dict中与word相邻的单词
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    private String replace(String s, int index, char c) { //把s中index的字符替换成c
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}

/*
Given two words (start and end), and a dictionary, 
find all shortest transformation sequence(s) from start to end, such that:

1 Only one letter can be changed at a time
2 Each intermediate word must exist in the dictionary

Notice
1 All words have the same length.
2 All words contain only lowercase alphabetic characters.

Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Tags 
Backtracking, Depth First Search, Breadth First Search

思路:
求最短距离的所有解，利用BFS + DFS.
(1) BFS过程与Word Ladder类似，但是在BFS过程:
利用一个HashMap(distance)记录每个单词距start的最短距离，
另一个HashMap(map)记录每个单词是由哪些单词变换一步得到的.

(2) DFS过程类似Permutation，从end出发，逐个寻找其上一节点直到start.
其中可能的上一节点可以由(1)中的map得到，但是只有距离start比当前节点小1的上一节点才是合法的
(保证其一定在end和start之间的最短路径上,即找到的下一个点一定比当前点离start更近,
 这样防止搜到的下一个点向外走), 距离可以由(1)中的distance得到.
当到达start时即找到一种解,因为是从end出发,所以要reverse成正序后再加入res，
然后reverse回逆序后删除刚加入元素,再回溯寻找下一个解.

注意:在dfs获取nextWord的list的时候,需要判断word是否在map中,否则可能得到null而造成之后的运行时异常.
比如start="hot", end="dog", dict={"hot", "dog"}, 这里在bfs中就找不到hot和dog的next,
因此没有元素会被加到map和distance中.
在lintcode里可以过,但是在leetcode里过不了.
*/
