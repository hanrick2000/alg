public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0){
            for(int i = 0; i < p.length(); i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        if (s == null){
            return p == null;
        }
        if (p == null){
            return s == null;
        }

        // state
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1]; //result[i][j]表示S的前i个字符能否和T的前j个字符匹配。
        // init
        result[0][0] = true;
        for(int j = 1; j <= p.length(); j++){ //即只有*才可能和空字符匹配
            if(result[0][j - 1] && p.charAt(j - 1) == '*'){
                result[0][j] = true;
            }
        }
        // function
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= p.length(); j++){
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'){
                    result[i][j] = result[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*'){
                    result[i][j] = (result[i - 1][j] || result[i][j - 1]);
                }
            }
        }
        // result
        return result[s.length()][p.length()];
     }
}

情况1. T(j) == ? || T(j) == S(i) 这时候 f(i, j) = f(i - 1, j - 1)。就是说T(j)必须去匹配，不然这个字母没意义了。
情况2. T(j) == *，此时分为两种情况。
    第一种情况让*的和S(i)匹配, 所以看result[i - 1][j]的值(j匹配完还在因为可以匹配任意长度字符); 
    第二种情况不让*和S(i)匹匹配(也可以看成*匹配为空字符），此时看result[i][j - 1]的值。
两种情况只要有只要有之只要有一种为true, 则result[i][j]则责=true。


Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false


    ^  a  a*
^   T  F  F
a   F
ab  F
abc F

    ^  a  a*
^   T  F  F
a   F  T  T
ab  F
abc F

    ^  a  a*
^   T  F  F
a   F  T  T
ab  F  F  T  让*匹配空字符, 看result[i][j-1]      ab  a  no
abc F        让*匹配S(i),   看result[i-1][j]      a   a* yes
             

    ^  a  a*
^   T  F  F
a   F  T  T
ab  F  F  T
abc F  F  T  让*匹配空字符, 看result[i][j-1]  abc a  no
             让*匹配S(i),   看result[i-1][j]  ab  a* yes
