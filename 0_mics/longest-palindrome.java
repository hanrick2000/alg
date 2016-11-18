public class Solution {
    public int longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] charStat = new int[52];
        int oddCharNumber = 0;
        int evenCharNumber = 0;
        for(char ch : s.toCharArray()){
            //for a-z
            if(ch >= 'a'){
                charStat[26 + ch - 'a']++;
            }else{
                charStat[ch - 'A']++;
            }
        }
        for(int cnt : charStat){
            if(cnt > 0){
                if(cnt % 2 == 0){
                    evenCharNumber += cnt;
                }else{
                    if(cnt == 1){
                        oddCharNumber++;
                    }else{
                        evenCharNumber += cnt - 1;
                        oddCharNumber++;
                    }
                } 
            }
        }
        if(oddCharNumber > 0){
            return evenCharNumber + 1;    
        }
        return evenCharNumber;
    }
}

/*
65  A
90  Z
97  a
122 z
*/

public class Solution {
    public int longestPalindrome(String s) {
        int[] charStatArray = new int[52];
        int oneTimeOddCount = 0;
        int evenCount = 0;
    
        for (char ch: s.toCharArray()) {
            if (ch >= 97) {
                charStatArray[26 + ch - 'a']++;
            }
            else {
                charStatArray[ch - 'A']++;
            }
        }
    
        for (int cnt: charStatArray) {
            if (cnt != 0) {
                if (cnt % 2 == 0) {
                    evenCount += cnt;
                } else {
                    if (cnt == 1) {
                        oneTimeOddCount++;
                    }
                    else {
                        evenCount += cnt - 1;
                        oneTimeOddCount++;
                    }
                }
            }
        }
    
        return oneTimeOddCount > 0 ? 1 + evenCount : evenCount;
    }
}

/*
Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:
Input:
"abccccdd"
Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Company Tags Google
Tags Hash Table
Similar Problems (E) Palindrome Permutation
*/
 
