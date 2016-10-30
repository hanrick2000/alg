class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k <= 0){
            return 0;
        }
        //greedy
        if(k >= prices.length / 2){
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int n = prices.length;
        int[][] mustsell = new int[n + 1][k + 1];
        int[][] globalbest = new int[n + 1][k + 1];

        for(int j = 0; j <= k; j++){
            mustsell[1][j] = globalbest[1][j] = 0;
        }
        for(int i = 2; i <= n; i++){
            int gainorlose = prices[i - 1] - prices[i - 2];
            mustsell[i][0] = globalbest[i][0] = 0;
            for(int j = 1; j <= k; j++){
                mustsell[i][j] = Math.max(globalbest[i - 1][j - 1], mustsell[i - 1][j]) + gainorlose;
                globalbest[i][j] = Math.max(globalbest[i - 1][j], mustsell[i][j]);
            }
        }
        return globalbest[n][k];
    }
};

如果k一半元素的数量prices.length/2还大，则可以用贪心算法，把后一天比前一天大的值都加进来。最坏的情况是一天比前一天大，一天比前一天小，这样最多也就是交易prices.length/2次。
否则就要用dp。思想和Maximum Subarray III一样。mustSell[i][j]表示前i天最多进行j次交易并且第i天必须卖出的最大值。globalBest[i][j]表示前i天最多进行j次交易且第i天不一定要卖出的最大值。
初始化：mustSell[1][j]=globalBest[1][j]=0，即不管交易多少次，前1天买进后卖出所得利润最大为0。
状态函数：
mustSell[i][j]=max(globalBest[i-1][j-1], mustSell[i-1][j])
第i天必须交易能获得的最大值分两种情况讨论：1）前i-1天交易j－1次，再加上第i天的1次交易，正好是前i天交易j次。2）前i－1天交易j次并且第i－1天必须交易，则第i天的交易可以合并到最后一次交易中，即第i－1天卖出之后再买入，然后再第i天卖出的结果和在第i－1天不交易而直接在第i天交易的结果是一样的，因此两次交易可以合并，所以合并后这种情况也是前i天交易j次。这两种情况里面取大的为结果。
globalBest[i][j]=max(globalBest[i-1][j], mustSell[i][j])
第i天不一定要交易的最大值分两种情况讨论：1）第i天一定交易的最大值，即上面所求的mustSell[i][j]。2）第i天一定不交易的最大值，因为第i天确定不交易，所以只要看前i－1天的结果就可以了，即globalBest[i-1][j]。两个里面取大的。

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
Example
Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
Challenge 
O(nk) time.
