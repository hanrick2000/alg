public class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9; //表示当前len下有多少个数
        int start = 1; //表示当前len的数是从哪个数开始的
        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;//9 ->90 ->900
            start *= 10;//1 ->10 ->100
        }
        start += (n - 1) / len; //表示第n个数是序列中的第几个数字, 比如是123
        String s = Integer.toString(start); //s表示真正的数字对应的字符串,比如'123'
        return (int)(s.charAt((n - 1) % len) - '0');
    }
}
/*
Straight forward way to solve the problem in 3 steps:

find the length of the number where the nth digit is from
find the actual number where the nth digit is from
find the nth digit and return
n=23
len=1, count=9, start=1 因为23大于9, 说明第23位数不在len＝1的9个数里面
然后看len=2的, 90个数, 从第10个数开始, 往后90个数, 即10到99
我们把n减9,变成了找14位, 即把len＝1的所有数排除, 以len＝2的90个数, 最大长度是180位
这说明n＝23的数，在10到99之间, start=10表示从数字10开始, len=2, start增加(14-1)/2=6
这里为什么是14-1, 因为start是10开始的, 相当于index从0开始
这时start=16, 表示n＝23位实际是数字16中的某个位
最后看看是16这个数字中的哪一位, (14-1)%2=1, 这里-1是因为s字符串是从0开始的, s.charAt(1)就是6
Character.getNumbericValue('6')就是得到6

n=14
len=2, count=90, start=10
start=
                      |
12345678910111213141516171819202122232324252627282930
         10111213141516171819202122232324252627282930....99
*/

/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
Example 1:
Input:
3
Output:
3
Example 2:
Input:
11
Output:
0
Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, 
which is part of the number 10.
Company Tags Google
Tags Math
*/
