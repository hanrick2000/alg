public class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = factorial[i-1] * i;
        }
        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }
        k--;
        for(int i = 1; i <= n; i++){
            int index = k / factorial[n - i]; //计算当前应该取哪个字母
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k = k % factorial[n - i]; //计算下一个k
        }
        return String.valueOf(sb);
    }
}




/*
I'm sure somewhere can be simplified so it'd be nice if anyone can let me know. The pattern was that:
say n = 4, you have {1, 2, 3, 4}
If you were to list out all the permutations you have
1 + (permutations of 2, 3, 4)
2 + (permutations of 1, 3, 4)
3 + (permutations of 1, 2, 4)
4 + (permutations of 1, 2, 3)


We know how to calculate the number of permutations of n numbers... n! 
So each of those with permutations of 3 numbers means there are 6 possible permutations. 
Meaning there would be a total of 24 permutations in this particular one. 
So if you were to look for the (k = 14) 14th permutation, it would be in the

3 + (permutations of 1, 2, 4) subset.

To programmatically get that, you take k = 13 (subtract 1 because of things always starting at 0) 
and divide that by the 6 we got from the factorial, which would give you the index of the number you want. 
In the array {1, 2, 3, 4}, k/(n-1)! = 13/(4-1)! = 13/3! = 13/6 = 2. The array {1, 2, 3, 4} has a value of 3 at index 2. 
So the first number is a 3.

Then the problem repeats with less numbers.

The permutations of {1, 2, 4} would be:

1 + (permutations of 2, 4)
2 + (permutations of 1, 4)
4 + (permutations of 1, 2)

But our k is no longer the 14th, because in the previous step, 
we've already eliminated the 12 4-number permutations starting with 1 and 2. 
So you subtract 12 from k. 
which gives you 1. Programmatically that would be. k = k - (index from previous) * (n-1)! = k - 2*(n-1)! = 13 - 2*(3)! = 1

In this second step, permutations of 2 numbers has only 2 possibilities, 
meaning each of the three permutations listed above a has two possibilities, 
giving a total of 6. 
We're looking for the first one, so that would be in the 1 + (permutations of 2, 4) subset.

Meaning: index to get number from is k / (n - 2)! = 1 / (4-2)! = 1 / 2! = 0.. from {1, 2, 4}, index 0 is 1

so the numbers we have so far is 3, 1... and then repeating without explanations.

{2, 4}

k = k - (index from pervious) * (n-2)! = k - 0 * (n - 2)! = 1 - 0 = 1;

third number's index = k / (n - 3)! = 1 / (4-3)! = 1/ 1! = 1... from {2, 4}, index 1 has 4

Third number is 4


{2}

k = k - (index from pervious) * (n - 3)! = k - 1 * (4 - 3)! = 1 - 1 = 0;

third number's index = k / (n - 4)! = 0 / (4-4)! = 0/ 1 = 0... from {2}, index 0 has 2

Fourth number is 2


Giving us 3142. If you manually list out the permutations using DFS method, it would be 3142. Done! It really was all about pattern finding.


这道题是让求出n个数字的第k个排列组合，由于其特殊性，我们不用将所有的排列组合的情况都求出来，
然后返回其第k个，我们可以只求出第k个排列组合即可，
那么难点就在于如何知道数字的排列顺序，
可参见网友喜刷刷的博客，
首先我们要知道当n = 3时，其排列组合共有3! = 6种，当n = 4时，其排列组合共有4! = 24种，
我们就以n = 4, k = 17的情况来分析，所有排列组合情况如下：

1234
1243
1324
1342
1423
1432
2134
2143
2314 
2341
2413
2431
3124
3142
3214
3241
3412  <--- k = 17
3421
4123
4132
4213
4231
4312
4321

我们可以发现，每一位上1,2,3,4分别都出现了6次，当第一位上的数字确定了，后面三位上每个数字都出现了2次，
当第二位也确定了，后面的数字都只出现了1次，当第三位确定了，
那么第四位上的数字也只能出现一次，
那么下面我们来看k = 17这种情况的每位数字如何确定，由于k = 17是转化为数组下标为16：

最高位可取1,2,3,4中的一个，每个数字出现3！= 6次，所以k = 16的第一位数字的下标为16 / 6 = 2，即3被取出
第二位此时从1,2,4中取一个，k = 16是此时的k' = 16 % (3!) = 4，而剩下的每个数字出现2！= 2次，所以第二数字的下标为4 / 2 = 2，即4被取出
第三位此时从1,2中取一个，k' = 4是此时的k'' = 4 % (2!) = 0，而剩下的每个数字出现1！= 1次，所以第三个数字的下标为 0 / 1 = 0，即1被取出
第四位是从2中取一个，k'' = 0是此时的k''' = 0 % (1!) = 0，而剩下的每个数字出现0！= 1次，所以第四个数字的下标为0 / 1= 0，即2被取出

那么我们就可以找出规律了
a1 = k / (n - 1)!
k1 = k

a2 = k1 / (n - 2)!
k2 = k1 % (n - 2)!
...

an-1 = kn-2 / 1!
kn-1 = kn-2 / 1!

an = kn-1 / 0!
kn = kn-1 % 0!





The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

Hide Company Tags Twitter
Hide Tags Backtracking Math
Hide Similar Problems (M) Next Permutation (M) Permutations
*/

