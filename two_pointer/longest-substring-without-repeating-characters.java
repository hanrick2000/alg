public class Solution{
    public int lengthOfLongestSubstring(String s){
        int ans = 0;
        int n= s.length();
        int[] map = new int[256];
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < n){
                if(map[s.charAt(j)] == 0){
                    map[s.charAt(j)] = 1;
                    ans = Math.max(ans, j - i + 1);
                    j++;
                }else{ //有重复了
                    break;
                }
            }
            map[s.charAt(i)] = 0;
        }
        return ans;
    }
}

/*
O(n^2)基本方法
*/

public class Solution{
    public int lengthOfLongestSubstring(String s){
        int ans = 0;
        int n = s.length();
        int[] map = new int[256];
        for(int i=0; i<n; i++){
            Arrays.fill(map, 0);
            for(int j=i; j<n; j++){ //j没有必要回退到i, 得到上面的方法
                if(map[s.charAt(j)] == 0){
                    map[s.charAt(j)] = 1;
                    ans = Math.max(ans, j - i + 1);
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}


/*
Given a string, find the length of the longest substring without repeating characters.
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
Challenge 
O(n) time
*/

//想想这个case:abcaefgbb, 最后的两个b, map中只会剩1个b

//Two pointer, 窗口类

