public class Solution {
    public class Node {
        public int degree;
        public ArrayList<Integer> neighbour = new ArrayList<Integer>();
        void Node() {
            degree = 0;
        }
    }
    public String alienOrder(String[] words) {
        Node[] node = new Node[26];
        boolean[] happen = new boolean[26];
        for (int i = 0; i < 26; i++) {
            node[i] = new Node();
        }
        //Build the Graph
        for (int i = 0; i < words.length; i++) {
            int startPoint = 0, endPoint = 0;
            for (int j = 0; j < words[i].length(); j++) {
                happen[charToInt(words[i].charAt(j))] = true;
            }
            if (i != words.length - 1) {
                for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                    if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                        startPoint = charToInt(words[i].charAt(j));
                        endPoint = charToInt(words[i + 1].charAt(j));
                        break;
                    }
                }
            }
            if (startPoint != endPoint) {
                node[startPoint].neighbour.add(endPoint);
                node[endPoint].degree++;
            }
        }
        //Topological Sort
        Queue<Integer> queue = new LinkedList<Integer>();
        String ans = "";
        for (int i = 0; i < 26; i++) {
            if (node[i].degree == 0 && happen[i]) {
                queue.offer(i);
                ans = ans + intToChar(i);
            } 
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : node[now].neighbour) {
                node[i].degree--;
                if (node[i].degree == 0) {
                    queue.offer(i);
                    ans = ans + intToChar(i);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (node[i].degree != 0) {
                return "";
            }
        }
        return ans;
    }
    public char intToChar(int i) {
        return (char)('a' + i);
    }
    public int charToInt(char ch) {
        return ch - 'a';
    }
}
