public char findTheDifference(String s, String t) {
    //s是源字符串, t是变换后增加了1个字符的字符串
    int n = t.length();
    char c = t.charAt(n - 1);
    for (int i = 0; i < n - 1; ++i) {
        c ^= s.charAt(i);
        c ^= t.charAt(i);
    }
    return c;
}

/*
3     = 011
4     = 100
3^4   = 111
3^3^4 = 100
3 011
3 011
  000
4 100
  100
*/

public class Solution {
    public char findTheDifference(String s, String t) {
        // Initialize variables to store sum of ASCII codes for 
        // each string
        int charCodeS = 0, charCodeT = 0;
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) charCodeS += (int)s.charAt(i);
        for (int i = 0; i < t.length(); ++i) charCodeT += (int)t.charAt(i);
        // Return the difference between 2 strings as char
        return (char)(charCodeT - charCodeS);
    }
}

/*
Given two strings s and t which consist of only lowercase letters.
String t is generated by random shuffling string s 
and then add one more letter at a random position.
Find the letter that was added in t.
Example:
Input:
s = "abcd"
t = "abcde"
Output:
e
Explanation:
'e' is the letter that was added.
Company Tags Google
Tags: Hash Table, Bit Manipulation
Similar Problems: (E) Single Number
*/
