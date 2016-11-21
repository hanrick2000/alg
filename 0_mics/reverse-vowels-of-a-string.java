public class Solution {
    public String reverseVowels(String s) {
        int[] pos = new int[s.length()];
        int cnt = 0;
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        for (int i = 0; i < s.length(); i++) {
            if (vowel.contains(s.charAt(i))) {
                pos[cnt] = i;
                cnt++;
            }
        }
        char[] ans = s.toCharArray();
        for (int i = 0; i < cnt; i++) {
            ans[pos[i]] = s.charAt(pos[cnt - i - 1]);
        }
        return String.valueOf(ans);
    }
}
/*
Write a function that takes a string as input and reverse only the vowels of a string.
Example 1:
Given s = "hello", return "holle".
Example 2:
Given s = "leetcode", return "leotcede".
Note:
The vowels does not include the letter "y".
Company Tags Google
Tags Two Pointers String
Similar Problems (E) Reverse String
*/
