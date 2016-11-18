public static int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
        return 1;
    }
    int ans = 10;
    int base = 9;
    for (int i = 2; i <= n && i <= 10; i++) {
        base = base * (9 - i + 2);
        ans += base;
    }
    return ans;
}



//DP Solution
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        if (n > 10) {
            n = 10;
        }
        //g[i]表示不含0的前i位数中满足条件的数的个数
        //f[i]表示含有0的前i位数中满足条件的数的个数
        int[] f = new int[11];
        int[] g = new int[11];
        int ans = 10;
        g[0] = 1; //不含0的前0位数没有重复的个数是1个
        g[1] = 9; //不含0的前1位数没有重复的个数是9个
        for (int i = 2; i <= n; i++) {
            g[i] = g[i-1] * (10 - i);
            f[i] = f[i-1] * (11 - i) + g[i-2] * (11 - i);
            ans += f[i] + g[i];
        }
        return ans;
    }
}
g[2] = g[1] * (10 - 2) = 9*8 = 72


//Math Method
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 10) {
            n = 10;
        }
        int ans = 1;
        int multiple = 9;
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                ans += multiple;
            } else {
                ans += (n - i + 1) * multiple;
            }
            multiple = multiple * (10 - n + i - 1);
        }
        return ans;
    } 
}


/*
题目描述
给出一个非负整数，在[0, 10^n)范围内统计各个数位上的数字均不同的整数个数。

举个栗子:
当n＝2，答案为91，排除掉{11,22,33,44,55,66,77,88,99}

算法分析

首先我们来分析一下题目，整数的范围为0到10^n，因为n是int类型，10^n次方非常大，似乎很难用穷举的方法。
但考虑不同的数字一共只有0-9，10个，因此根据抽屉原理（鸽笼原理）[把k个物品放到k－1个抽屉必有一个抽屉至少有两个物品]，
当n大于10，必定有某个数字出现至少两次。因此我们只需要考虑区间[0-10^10)即可。

即使缩小了范围，穷举仍然是效率极低的。对于本题，刷题君提出两种算法：动态规划和数学方法。

此类数字统计问题一般是可以用动态规划加快统计速度的。
刷题君用
f[i]表示不含0的i位数中满足条件的有几个，
g[i]表示含有0的i位数中满足条件的有几个。

f[i] = f[i-1] * (11 - i) + g[i-2] * (11 - i)
g[i] = g[i-1] * (10 - i)

最后把所有的f和g值累计即可。本题有多种可行的状态表示，只要能统计出最后结果、方便转移就可以了。

我们也可以用排列组合的知识解决此题。
如果是n位数，相当于在10个数字（0到9）中取出n个数字，放在n个数位上，有多少种方法，答案为A(10, n)。
但我们用样例n＝2测试发现，A(10,2) = 90，还差1。
也就是说有一个数被我们遗漏，它就是0。因为当表示为两位数是，0写成00，0出现了两次，我们并没有统计这种情况。
一个idea是根据0的个数进行统计，比如n=3时，没有0的满足条件的整数有9*8*7个，
有一个0的满足条件的整数有3*9*8个（3是指有3个位置可以放0），
有两个0的满足条件的整数有2*9个（当有两个0时，一定有一个0在最高位，另一个0有两个位置可以选择），
有三个0的满足条件的整数只有1个（就是000）。

面试官角度分析

这道题相对不管从动态规划的思路还是数学来想都相对比较难， 如果能够分析出动态规划的思路和抽屉原理，就可以达到hire的程度

This is a digit combination problem. Can be solved in at most 10 loops.
When n == 0, return 1. I got this answer from the test case.
When n == 1, _ can put 10 digit in the only position. [0, ... , 10]. Answer is 10.
When n == 2, _ _ first digit has 9 choices [1, ..., 9], second one has 9 choices excluding the already chosen one. So totally 9 * 9 = 81. answer should be 10 + 81 = 91
When n == 3, _ _ _ total choice is 9 * 9 * 8 = 684. answer is 10 + 81 + 648 = 739
When n == 4, _ _ _ _ total choice is 9 * 9 * 8 * 7.
...
When n == 10, _ _ _ _ _ _ _ _ _ _ total choice is 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
When n == 11, _ _ _ _ _ _ _ _ _ _ _ total choice is 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 * 0 = 0



*/
