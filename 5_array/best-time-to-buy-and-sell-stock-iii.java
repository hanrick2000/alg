public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] left = new int[prices.length]; //left[i]表示从0到i交易1次可以取得的最大值
        int[] right = new int[prices.length]; //right[i]表示从i到n-1交易1次可以取得的最大值
        // DP from left to right;
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {//因为是从前向后走, 计算最大值需要记录遇到的最小值
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        //DP from right to left;
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {//因为从后向前走,计算最大值需要记录遇到的最大值
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            profit = Math.max(left[i] + right[i], profit);  
        }
        return profit;
    }
}

/*
III是这三题中最难的。允许两次买卖，但同一时间只允许持有一支股票。
也就意味着这两次买卖在时间跨度上不能有重叠（当然第一次的卖出时间和第二次的买入时间可以是同一天）。
既然不能有重叠可以将整个序列以任意坐标i为分割点，分割成两部分：

prices[0:n-1] => prices[0:i] + prices[i:n-1]

对于这个特定分割来说，最大收益为两段的最大收益之和。每一段的最大收益当然可以用I的解法来做。
而III的解一定是对所有0<=i<=n-1的分割的最大收益中取一个最大值。
为了增加计算效率，考虑采用dp来做bookkeeping。目标是对每个坐标i：

1. 计算A[0:i]的收益最大值：用minPrice记录i左边的最低价格，用maxLeftProfit记录左侧最大收益
2. 计算A[i:n-1]的收益最大值：用maxPrices记录i右边的最高价格，用maxRightProfit记录右侧最大收益。
3. 最后这两个收益之和便是以i为分割的最大收益。将序列从左向右扫一遍可以获取1，从右向左扫一遍可以获取2。相加后取最大值即为答案。

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
Example
Given an example [4,4,6,1,1,4,2,5], return 6.




*/

