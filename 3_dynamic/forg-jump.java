class Solution{
    public boolean canCross(int[] stones) {
        // state
        boolean[][] f = new boolean[stones.length][]; //f[i][j]表示能否通过跳j段到达第i块石头
        int maxJump = 0;
        int pos;

        // init
        f[0] = new boolean[]{true}; //f[0][0] =  true;

        // function
        for (int i = 1; i < stones.length; i++) { //枚举每一个位置i
            //It should be maxJump + 1 but we have a useless f[i][0] so it's maxJump + 2
            f[i] = new boolean[maxJump + 2];
            for (int j = 1; j < f[i].length; j++) { //枚举当前的位置i, 是经过多少跳过来的
                pos = findPos(stones, i, j); //findPos(i,j)返回的是在第几个石块上经过了j跳到了第i个石块上
                if (pos != -1) {
                    //Check to prevent array out of bounds
                    if ((j + 1 < f[pos].length && f[pos][j + 1]) || (j < f[pos].length && f[pos][j]) || (j - 1 < f[pos].length && f[pos][j - 1])) {
                        f[i][j] = true;
                        maxJump = maxJump > j ? maxJump : j;
                    }
                }
            }
        }
        // result
        for (int i = 1; i < f[stones.length - 1].length; i++) {
            if (f[stones.length - 1][i]) {
                return true;
            }
        }
        return false;
    }

    //Find the position of (stones[currentPos] - units) in stones[]
    public int findPos(int[] stones, int currentPos, int units) { //找到是stones[]中的哪个Pos经过了units跳后到达了currentPos
        int targetUnit = stones[currentPos] - units;
        while (currentPos - 1 > 0 && stones[currentPos - 1] > targetUnit) {
            currentPos--;
        }
        if (stones[currentPos - 1] == targetUnit) {
            return currentPos - 1;
        } else {
            return -1;
        }
    }
}

/*
A frog is crossing a river. 
The river is divided into x units and at each unit there may or may not exist a stone. 
The frog can jump on a stone, but it must not jump into the water.
Given a list of stones' positions (in units) in sorted ascending order, 
determine if the frog is able to cross the river by landing on the last stone. 
Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, 
then its next jump must be either k - 1, k, or k + 1 units. 
Note that the frog can only jump in the forward direction.

Note:

1 The number of stones is ≥ 2 and is < 1,100.
2 Each stone's position will be a non-negative integer < 231.
3 The first stone's position is always 0.

Example 1:
 1 2 3 4 5 6  7 8
[0,1,3,5,6,8,12,17]
   1 2 3   3  4 5

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:
 1 2 3 4 5 6 7 8
[0,1,2,3,4,8,9,11]
   1 1 1 1 X
Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.
Company Tags Snapchat
Tags Dynamic Programming
*/


/*
解题思路分析

看到这道题，有动态规划的特征。
首先判断能不能到达某状态是动规的常见题型，
其次后面的状态需要用到前面的状态（即问题可以分解），所以从动态规划的角度分析一下。

状态
这道题难以下手的地方就在于一个状态不只和当前点（青蛙所处的位置）有关，
还和跳了多少段到当前位置有关，因为这个数值影响了下一跳的范围。
所以每一个状态要记录两个值，我们用d(i, j)来表示，d(i, j)本身定义为一个布尔型，表示能否通过跳j段到达第i块石头。

方程
当我们定义好状态后，方程就显得较为自然了。不过我们首先定义两个东西。
一、
题目中所给的表示石头位置的升序列表
我们把它定义为一个整数数组名为stones[]

二、
一个pos(x)函数，这个函数返回一个整数
这个整数表示第x段的石头是这条河中的第几块石头（即给一个整数，返回这个整数在stones[]数组的下标）

假若第x段没有石头（即stones数组中不包含这个数）就返回-1。
于是我们就有方程d(i, j) = d(pos(stones[i]-j), j-1) || d(pos(stones[i]-j), j) || d(pos(stones[i]-j), j+1). 

简要解释一下，跳了j段到达第i块石头，意味着是从第pos(stones[i]-j)块石头跳过来的（如果这块石头存在）。
又因为跳了j段，所以上一跳所跳的段数必须是j、j-1或j+1的其中之一。
所以三个值中若有一个是可达的，那么d(i, j)就也是可达的。
当然，若第pos(stones[i]-j)块石头就不存在，那么当然d(i,j)也就不可达。

初始化和最终状态
依据题意，初始状态时d(0, 0)为true。对于最终状态，假设河中一共有x块石头，那么若d(x, *)中有任何一个位置是true就返回true，否则返回false。
动规思路分析完毕后我们再分析一下一些编程细节。
跳过的段数要计算到多少（即d(i, j)中每一层的j要计算到多少）。这里我们通过思考可以发现，这个数量最多不会超过历史最远的一跳+1。所以我们维护一个历史最远跳来作为这里所跳段数的边界。
注意数组超界问题，因为所跳段数可以减一，所以要控制其必须大于0。
这道题用广度优先搜索亦可，但是要注意调至同一个石头时所跳的段数不同，结果并不同，所以记录是否入队的数组依然要是二维的。

面试官角度分析
这道题的重点是要能发现状态的记录方法和相应方程。若还能注意到编程中的几个注意点(比如dp状态的处理)便可给面试官一个上佳的印象。
*/
