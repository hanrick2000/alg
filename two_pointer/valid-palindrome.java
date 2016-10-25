public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int front = 0;
        int end = s.length() - 1;
        int n = s.length();
        while (front < end) {
            while (front < n && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }
            if (front == n) { // for emtpy string “.,,,”
                return true; 
            }           
            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break; //如果front和end的字符不相等, 那么就退出while循环了
            } else {
                front++;
                end--;
            }
        }
        return end <= front; //想想[a b c c b a]和[a b c b a]两种情况
    }
    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
Example
"A man, a plan, a canal: Panama" is a palindrome.
amanaplana c amanaplana
"race a car" is not a palindrome.
raceacar
Challenge 
O(n) time without extra memory.
*/

