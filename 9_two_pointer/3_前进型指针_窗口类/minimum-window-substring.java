public class Solution {    
    public String minWindow(String Source, String Target) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        initTargetHash(targethash, Target);
        int j = 0;
        int i = 0;
        for(i = 0; i < Source.length(); i++) {
            while(!valid(sourcehash, targethash) && j < Source.length()) {
                sourcehash[Source.charAt(j)]++;
                if(j < Source.length()){
                    j++;
                }else{ 
                    break;
                }
            }
            if(valid(sourcehash, targethash) ){
                if(ans > j - i){
                    ans = Math.min(ans, j - i);
                    minStr = Source.substring(i, j);
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }
    void initTargetHash(int []targethash, String Target) {
        for (char ch : Target.toCharArray()) {
            targethash[ch]++;
        }
    }
    boolean valid(int []sourcehash, int []targethash) {
        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])    
                return false;
        }
        return true;
    }
}



/*
Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
If there is no such window in source that covers all characters in target, return the emtpy string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
Clarification
Should the characters in minimum window has the same order in target?
Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC", target可以重复
Challenge 
Can you do it in time complexity O(n) ? O(256n)
*/

