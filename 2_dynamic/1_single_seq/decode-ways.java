public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        // state
        int[] f = new int[n + 1]; //前i个字母有多少中decode方法
        // init
        f[0] = 1;
        f[1] = s.charAt(0) != '0' ? 1 : 0;
        // function, 以i为结尾的方案数 = 以i-1为结尾的方案数(i不是0) + 以i-2为结尾的方案数([i-1, i]是10到26之间)
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                f[i] = f[i] + f[i - 2];
            }
        }
        // result
        return f[n];
    }
}


A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
Example
Given encoded message 12, it could be decoded as AB (1 2) or L (12).
The number of ways decoding 12 is 2.
