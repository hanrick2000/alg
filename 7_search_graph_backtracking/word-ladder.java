public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);  //把start和end放入dict
        dict.add(end);
        HashSet<String> set = new HashSet<String>(); //需要个set记录哪些访问过
        Queue<String> queue = new LinkedList<String>(); //queue则是BFS下一轮要遍历的节点
        queue.offer(start); //把start放入queue中作为开始
        set.add(start); //start放入set说明已经访问过start了
        int length = 1; 
        //length记录的是经过了多少次变换, 每轮BFS时length会增加, 本题就是看经过几轮BFS可以找到end
        while(!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    set.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
    private ArrayList<String> getNextWords(String word, Set<String> dict) { 
        //寻找在dict中与word相邻的所有单词
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
find the length of shortest transformation sequence from start to end, such that:
1 Only one letter can be changed at a time
2 Each intermediate word must exist in the dictionary
Notice:
1 Return 0 if there is no such transformation sequence.
2 All words have the same length.
3 All words contain only lowercase alphabetic characters.
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Tags 
LinkedIn, Breadth First Search
*/

/*
思路： 
LeetCode中为数不多的考图的难题。
尽管题目看上去像字符串匹配题，
但从"shortest transformation sequence from start to end"
还是能透露出一点图论中最短路径题的味道。如何转化?
1. 将每个单词看成图的一个节点。
2. 当单词s1改变一个字符可以变成存在于字典的单词s2时，则s1与s2之间有连接。
3. 给定s1和s2，问题I转化成了求在图中从s1->s2的最短路径长度。而问题II转化为了求所有s1->s2的最短路径。

无论是求最短路径长度还是求所有最短路径, 都是用BFS. 在BFS中有三个关键步骤需要实现:
1. 如何找到与当前节点相邻的所有节点.
这里可以有两个策略：
(1) 遍历整个字典, 将其中每个单词与当前单词比较, 判断是否只差一个字符. 
    复杂度为：n*w, n为字典中的单词数量, w为单词长度.
(2) 遍历当前单词的每个字符x, 将其改变成a~z中除x外的任意一个, 形成一个新的单词, 
    在字典中判断是否存在. 复杂度为：26*w，w为单词长度.
这里可以和面试官讨论两种策略的取舍. 对于通常的英语单词来说, 长度大多小于100, 
而字典中的单词数则往往是成千上万, 所以策略2相对较优.
2. 如何标记一个节点已经被访问过, 以避免重复访问.
set里面有的就是访问过的
3. 一旦BFS找到目标单词, 如何backtracking找回路径?
*/
