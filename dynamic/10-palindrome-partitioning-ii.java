public class Solution {
    private boolean[][] getIsPalindrome(String s) {//存在依赖关系, 一个长的字符串是否回文依赖于小的回文, 这也是一个动态规划(区间型动态规划), 严格意义来说是递推(因为暴力算法是n^3), 长区间依赖于短区间
        boolean[][] f = new boolean[s.length()][s.length()]; //f[i][j]表示i与j之间的字符串能否构成回文
        for (int i = 0; i < s.length(); i++) { //单独字母是回文
            f[i][i] = true; //从i到i
        }
        for (int i = 0; i < s.length() - 1; i++) { //判断从起点i开始, 长度是1的2字母子串是否回文
            f[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int length = 2; length < s.length(); length++) {//判断从i开始, 长度是2到s.length()的子串是否回文, 先for长度, 再for起点
            for (int start = 0; start + length < s.length(); start++) {
                f[start][start + length] = f[start + 1][start + length - 1] 
                                           && s.charAt(start) == s.charAt(start + length); 
                //这里利用了递推信息, 对于[start, start+length], [start+1, start+length-1]如果是回文的,那么就看start位置和start+length位置是否一样, 就能知道[start, start+length]是否回文了
            }
        }
        return f;
    }
    public int minCut(String s) {
        // 异常检测
        if (s == null || s.length() == 0){
            return 0;
        }
        // preparation
        boolean[][] isPalindrome = getIsPalindrome(s); //这个子问题也可以考
        // init
        int[] f = new int[s.length() + 1]; //表示前i个字母，最少可以被分割为多少个回文串
        f[0] = 0; //空串一个回文串都没有
        // function 
        for (int i = 1; i <= s.length(); i++) {
            f[i] = Integer.MAX_VALUE; // or f[i] = i
            for (int j = 0; j < i; j++) { //     [0,...j,...i-1],  分成[0,j]
                if (isPalindrome[j][i - 1]) { //如果j+1到i这一段是个回文串, 这里j是以0开始的第j+1个字母, i-1因为i表示的是前i个字母, i-1才是以0为开始的第i个字母
                    f[i] = Math.min(f[i], f[j] + 1); //f[j]表示的是前j个字母, 最少可以被分割为多少个回文串, min{f[j]+1}, j< i && [j+1,i]这一段是一个回文串
                }
            }
        }
        //result
        return f[s.length()] - 1;
    }
}







// version 2
// f[i] 表示前i个字母，最少被切割几次可以切割为都是回文串。
// 最后return f[n]
public class Solution {
    /*
    private boolean isPalindrome(String s, int start, int end) {//最直接的方法判断start和end之间是不是回文串, O(n), 如果要用这个, 整体就是O(n^3)的复杂度
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    */
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length); 
            }
        }
        return isPalindrome;
    }
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        // preparation
        boolean[][] isPalindrome = getIsPalindrome(s); //从任意位置到任意位置是否是个回文串
        // initialize
        int[] f = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            f[i] = i - 1; //f[0] 为 -1需要分析理解, 代表空串, 这样理解, 比如对于aba, isPalindrome[0][2]是true, 表示aba是个回文串, 切的一刀是"", "aba", 因为我们知道f[2]应该是0, f[0]+1应该等于0, 所以f[0]要是-1才行, 这个是反过来理解的。还是看version1的实现吧.
        }
        // main
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {//从j到i-1是不是回文串, 用预处理的矩阵
                //if(isPalindrome(s, j, i-1); //用函数
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()];
    }
}

/*
Palindrome Partitioning II
Given a string s, cut s into some substrings such that every substring is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
Example
Given s = "aab",
Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.
*/

/*
// version 1
f[i] 表示前i个字母，最少可以被分割为多少个回文串
最后return f[n] - 1
eg: f("aba")=1  最少分割成1个回文串, f("abab")=2 最少分割成2个回文串
*/

isPalindrome的填表过程, 先for长度, 再for起点 
for length 2->n
  for start 0->n-length
    update f[start][start+length]

     01234
str="aabbc"
  0 1 2 3 4 end
0 T        
1   T      
2     T    
3       T  
4         T
start

     01234
str="aabbc"
  0 1 2 3 4 end
0 T T      
1   T F    
2     T T  
3       T F 
4         T
start

     01234
str="aabbc"
  0 1 2 3 4 end
0 T T F    
1   T F F  
2     T T F
3       T F 
4         T
start

     01234
str="aabbc"
  0 1 2 3 4 end
0 T T F F  
1   T F F F
2     T T F
3       T F 
4         T
start

     01234
str="aabbc"
  0 1 2 3 4 end
0 T T F F F
1   T F F F
2     T T F
3       T F
4         T
start
