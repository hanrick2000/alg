public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return result;
        }
        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result); 
        return result;
    }
    private void helper(String s, ArrayList<String> path, int pos, ArrayList<ArrayList<String>> result) { //把所有以path开头, 从s中pos位置开始的, 所有合法结果加入到result中
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            path.add(prefix);
            helper(s, path, i, result);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() - 1;
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }
}

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
Example
Given s = "aab", return:
[
  ["aa","b"],
  ["a","a","b"]
]
Tags 
Backtracking, Depth First Search
