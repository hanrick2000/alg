//O(n^2) DP
class Solution{
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        // state
        boolean[][] f = new boolean[n][n]; //f[i][j]之间字符串是否能构成回文
        int max = 0;
        String sb = "";
    
        for(int i = 0; i < n; i++){
            f[i][i] = true;
            sb = s.substring(i, i + 1);
            max = 1;
        }
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
              f[i][i + 1] = true;
              sb = s.substring(i, i + 2);
              max = 2;
            }
        }
        for(int length = 2; length < n; length++){
            for(int start = 0; start + length < n; start++){
                if(s.charAt(start) == s.charAt(start + length)){
                    f[start][start + length] = f[start + 1][start + length -1];
                    if(f[start][start + length] == true){
                        if(length + 1 > max){
                            max = length + 1;
                            sb = s.substring(start, start + length + 1);
                        }
                    }
                }else{
                    f[start][start + length] = false;
                }
            }
        }
        // result
        return sb;
    }
}

//O(n)方法, 看不懂哦
class Solution{
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        int len = s.length();
        int max = -1;
        String sb = "";
        for(int i = 1; i < 2 * len; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * len && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--;
            if(count > max){
                max = count;
                sb = s.substring((i - count) / 2, (i + count) / 2);
            }
        }
        return sb;
    }
    
    private char get(String s, int index){
        if(index % 2 == 0){
            return '#';
        }else{
            return s.charAt(index / 2);
        }
    }
}



Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.

Example
Given the string = "abcdzdcab", return "cdzdc".

Challenge 
O(n2) time is acceptable. Can you do it in O(n) time.
