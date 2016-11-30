public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0; //profit表示在i位置时可以取得的最大profit
        int min = prices[0];  //just remember the smallest price
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}

/*
min记录遇到的最小值, 如果当前值与min能够产生更大的profit就更新profit
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Example
Given array [3,2,3,1,2], return 1.
Tags 
Greedy Enumeration Array Facebook Uber
*/
