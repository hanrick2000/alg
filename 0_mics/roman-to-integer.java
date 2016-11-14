public class Solution {
   public int romanToInt(String s) {
      if (s == null || s.length()==0) {
                return 0;
      }
      Map<Character, Integer> m = new HashMap<Character, Integer>();
      m.put('I', 1);
      m.put('V', 5);
      m.put('X', 10);
      m.put('L', 50);
      m.put('C', 100);
      m.put('D', 500);
      m.put('M', 1000);
      int length = s.length();
      int result = m.get(s.charAt(length - 1)); //先看最右边的值
      for (int i = length - 2; i >= 0; i--) {
          if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) { //如果i右边位置的值小于或等于i位置的值, 则加上i位置的值
              result += m.get(s.charAt(i));
          } else { //如果i右边位置的值大于i位置的值, 则减去i位置的值
              result -= m.get(s.charAt(i));
          }
      }
      return result;
  }
}

Given a roman numeral, convert it to an integer.
The answer is guaranteed to be within the range from 1 to 3999.
Clarification
What is Roman Numeral?
https://en.wikipedia.org/wiki/Roman_numerals
https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
http://baike.baidu.com/view/42061.htm
Example
IV -> 4
XII -> 12
XXI -> 21
XCIX -> 99 100-10+10-1=99
Tags 
String, Uber

罗马数字采用七个罗马字母作数字, 即Ⅰ(1), X(10), C(100), M(1000), V(5), L(50), D(500). 记数的方法:
相同的数字连写, 所表示的数等于这些数字相加得到的数, 如III=3;
小的数字在大的数字的右边, 所表示的数等于这些数字相加得到的数, 如 VII=8, XII=12;
小的数字(限于 Ⅰ、X 和 C)在大的数字的左边, 所表示的数等于大数减小数得到的数, 如 IV=4, IX=9;
