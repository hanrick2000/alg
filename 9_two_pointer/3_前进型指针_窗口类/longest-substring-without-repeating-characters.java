public class Solution{
    public int lengthOfLongestSubstring(String s){
        int ans = 0;
        int[] map = new int[256];
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length()){
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

//外层for循环i从0到n-1, 内层while循环从j到n-1, 如果map中没有j位置字符, 说明还没有重复, 把字符加入map并更新答案ans, j++
//如果发现map中有j位置字符了, 那么向前移动i, 并删掉map中i位置字符

/*
O(n^2)基本方法
*/

public class Solution{
    public int lengthOfLongestSubstring(String s){
        int ans = 0;
        int n = s.length();
        int[] map = new int[256];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){ //j没有必要回退到i, 得到上面的方法
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

