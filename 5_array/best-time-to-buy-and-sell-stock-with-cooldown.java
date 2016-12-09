public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int[] buy = new int[3];
        int[] sell = new int[3];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]); //第一天和第二天里只能买一次, 取最大值
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]); //只能在第二天卖, 跟0比较
        for(int i = 2; i < prices.length; i++){
            buy[i % 3] = Math.max(buy[(i - 1) % 3], sell[(i - 2) % 3] - prices[i]); // buy[i-1]是在i位置不买, sell(i-2)-prices[i]是在i位置买, 则必须是在在i-2的位置上最后一个操作是cell, 取那个最大值
            sell[i % 3] = Math.max(sell[(i - 1) % 3], buy[(i - 1) % 3] + prices[i]); // sell[i-1]是在i位置不卖, buy[i-1]+prices[i]是在i位置卖, 则前一个必须是买入
        }
        return sell[(prices.length - 1) % 3];
    }
}
/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:
prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
Company Tags Google
Tags Dynamic Programming
Similar Problems (E) Best Time to Buy and Sell Stock 
                 (M) Best Time to Buy and Sell Stock II
*/
