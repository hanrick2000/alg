class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int n = prices.length;
        int[][] mustSell = new int[n + 1][k + 1];
        // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalBest = new int[n + 1][k + 1];
        // globalBest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
        
        mustSell[0][0] = globalBest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustSell[0][i] = globalBest[0][i] = 0;
        }
        
        for (int i = 1; i < n; i++) { //前i天
            int gainOrLose = prices[i] - prices[i - 1];
            mustSell[i][0] = 0;
            for (int j = 1; j <= k; j++) { //最多k次交易
                mustSell[i][j] = Math.max(globalBest[(i - 1)][j - 1] + gainOrLose,
                                          mustSell[(i - 1)][j] + gainOrLose);
                globalBest[i][j] = Math.max(globalBest[(i - 1)][j], 
                                            mustSell[i][j]);
            }
        }
        return globalBest[(n - 1)][k];
    }
}


/*
如果k一半元素的数量prices.length/2还大,则可以用贪心算法,把后一天比前一天大的值都加进来.
最坏的情况是一天比前一天大,一天比前一天小,这样最多也就是交易prices.length/2次.

否则就要用dp.思想和maximum-subarray-iii一样,
mustSell[i][j]表示前i天最多进行j次交易并且第i天必须卖出的最大值.
globalBest[i][j]表示前i天最多进行j次交易且第i天不一定要卖出的最大值.

初始化: mustSell[1][j] = globalBest[1][j] = 0，即不管交易多少次，前1天买进后卖出所得利润最大为0。

状态函数：
mustSell[i][j] = max(globalBest[i - 1][j - 1], mustSell[i - 1][j])
第i天必须交易能获得的最大值分两种情况讨论:
1)前i - 1天交易j - 1次, 再加上第i天的1次交易, 正好是前i天交易j次.
2)前i - 1天交易j次并且第i - 1天必须交易,则第i天的交易可以合并到最后一次交易中,
(只有在前一天也交易时才能合并)
即第i - 1天卖出之后再买入,然后再第i天卖出的结果和在第i-1天不交易而直接在第i天交易的结果是一样的,
因此两次交易可以合并,所以合并后这种情况也是前i天交易j次.这两种情况里面取大的为结果.

globalBest[i][j] = max(globalBest[i - 1][j], mustSell[i][j])
第i天不一定要交易的最大值分两种情况讨论:
1)第i天一定交易的最大值,即上面所求的mustSell[i][j].
2)第i天一定不交易的最大值,因为第i天确定不交易,所以只要看前i-1天的结果就可以了,即globalBest[i - 1][j].
两个里面取大的.

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
Example
Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
Challenge 
O(nk) time.
*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2){
            return quickSolve(prices);
        }
        int[][] t = new int[k + 1][len]; //t[i][j]表示在第j天, 最多进行i次交易的最大利润
        for (int i = 1; i <= k; i++) { //i次交易
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) { //第j天
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }
    private int quickSolve(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++){
            if (prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}

/*
dp[i][j] = max(dp[i][j-1], prices[j] + maxTemp)  
我们能获取的最大利润, 当我们在第j天进行抛售时,
由于maxTemp已经算了买进时的价格，所以直接加上即可.

maxTemp = max(maxTemp,dp[i-1][j-1] – prices[j])  
可以理解为已获得的最大利润,即如果买进第j天的,
那么用之前一轮的买卖,前一天的的利润即(dp[i-1][j-1]) 减去prices[j]
*/
