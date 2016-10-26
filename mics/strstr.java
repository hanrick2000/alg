//返回target在source中的第一次出现下标
class Solution {
    public int strStr(String source, String target) {
        if(source == null || target == null) {
            return -1;
        }
        for(int i = 0; i < source.length() - target.length() + 1; i++){
            int j = 0;
            for(j = 0; j < target.length(); j++){
                if(source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if(j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}

/*
For a given source string and a target string, 
you should output the first index(from 0) of target string in source string.
If target does not exist in source, just return -1.
Do I need to implement KMP Algorithm in a real interview?
Not necessary. When you meet this problem in a real interview, 
the interviewer may just want to test your basic implementation ability. 
But make sure your confirm with the interviewer first.
Example
If source = "source" and target = "target", return -1.
If source = "abcdabcdefg" and target = "bcd", return 1.
*/
