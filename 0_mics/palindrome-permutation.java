public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(map.get(ch) != null){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        int oddCount = 0;
        for(int count : map.values()){
            if(count % 2 == 0){
                continue;
            }else{
                oddCount++;
            }
        }
        if(oddCount <= 1){
            return true;
        }
        return false;
    }
}

/*
Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
Hint:
1 Consider the palindromes of odd vs even length. What difference do you notice?
2 Count the frequency of each character.
3 If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
Company Tags Google Uber Bloomberg
Tags Hash Table
Similar Problems (M) Longest Palindromic Substring (E) Valid Anagram (M) Palindrome Permutation II (E) Longest Palindrome
*/
