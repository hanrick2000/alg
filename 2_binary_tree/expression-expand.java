public class Solution {
    /**
     * @param s an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        Stack<String> str = new Stack<String>();
        Stack<Integer> num = new Stack<Integer>();
        int number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                number = number * 10 + c - '0';
            else if (c == '[') {
                str.push("[");
                num.push(number);
                number = 0;
            } else if (c == ']') {
                Stack<String> temp = new Stack<String>();
                while (!str.empty()) {
                    String top = str.pop();
                    if (top.equals("[")) {
                        StringBuffer sb = new StringBuffer();
                        StringBuffer result = new StringBuffer();

                        while (!temp.empty())
                            sb.append(temp.pop());

                        int times = num.pop();
                        for (int i = 0; i < times; ++i)
                            result.append(sb.toString());

                        str.push(result.toString());
                        break;
                    }
                    temp.add(top);
                }
            } else
                str.add(String.valueOf(c));
        }

        Stack<String> temp = new Stack<String>();
        StringBuffer result = new StringBuffer();
        
        while (!str.empty())
            temp.add(str.pop());

        while (!temp.empty())
            result.append(temp.pop());
            
        return result.toString();
    }
}

Given an expression s includes numbers, letters and brackets. Number represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.

Have you met this question in a real interview? Yes
Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz

Challenge 
Can you do it without recursion?

Tags 
Divide and Conquer Recursion Stack Non Recursion Yahoo
