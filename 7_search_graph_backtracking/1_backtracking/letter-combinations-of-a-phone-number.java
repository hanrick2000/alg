public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.equals("")) {
            return result;
        }
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, result);
        return result;
    }
    private void helper(Map<Character, char[]> map, 
                        String digits, 
                        StringBuilder sb, 
                        ArrayList<String> result) {
        //递归结束条件: sb的长度和digits长度相等时, 即为一个解
        if (sb.length() == digits.length()) { 
            result.add(sb.toString());
            return;
        }
        // 递归拆解: 枚举digits在当前位置的所有可能解
        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(map, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

Given a digit string excluded 01, 
return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
2:a b c
3:d e f
4:g h i
5:j k l
6:m n o
7:p q r s
8:t u v
9:w x y z
Notice
Although the above answer is in lexicographical order, your answer could be in any order you want.
Example
Given "23"
Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Tags 
String, Backtracking, Recursion, Facebook, Uber
