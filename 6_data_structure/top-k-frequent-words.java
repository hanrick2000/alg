public class Solution {
    class Pair {
        String key;
        int value;
        Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        if (k == 0) {
            return new String[0];
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        //这里体现出先比较数量多少, 然后比较字符的字典序
        //还是min heap
        Comparator<Pair> pairComparator = new Comparator<Pair>() {
            public int compare(Pair left, Pair right) {
                if (left.value != right.value) {
                    return left.value - right.value;
                }
                return right.key.compareTo(left.key);
            }
        };
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>(k, pairComparator);
        for (String word : map.keySet()) {
            Pair peak = Q.peek(); //null if empty
            Pair newPair = new Pair(word, map.get(word));
            if (Q.size() < k) {
                Q.add(newPair);
            } else if (pairComparator.compare(newPair, peak) > 0) {
                Q.poll();
                Q.add(newPair);
            }
        }
        String[] result = new String[k];
        int index = k - 1;
        while (index >= 0) {
            result[index] = Q.poll().key;
            index--;
        }
        return result;
    }
}

/*
Given a list of words and an integer k, return the top k frequent words in the list.
Notice: You should order the words by the frequency of them in the return list, 
the most frequent one comes first. If two words has the same frequency, 
the one with lower alphabetical order come first.

Example
Given
[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].
for k = 4, return ["code", "lint", "baby", "yes"],

Challenge 
Do it in O(nlogk) time and O(n) extra space.
Extra points if you can do it in O(n) time with O(k) extra space approximation algorithms.
Tags: Hash Table, Heap, Priority Queue
*/
