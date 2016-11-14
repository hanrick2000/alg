public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length){
            return -1;
        }
        int n = gas.length;
        int sumGas = 0;
        int sumCost = 0;
        for(int i = 0; i < n; i++){
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if(sumGas < sumCost){
            return -1;
        }

        int start = 0;
        int diff = 0;
        for(int i = 0; i < n; i++){
            if(diff + gas[i] < cost[i]){
                start = i + 1;
                diff = 0;
            }else{
                diff += gas[i] - cost[i];
            }
        }
        return start;
    }
}

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Notice
The solution is guaranteed to be unique.
Example
Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. 
The starting gas station's index is 2.
Challenge 
O(n) time and O(1) extra space
Tags 
Greedy
Ref:
http://www.cnblogs.com/yuzhangcmu/p/4179228.html
https://zhengyang2015.gitbooks.io/lintcode/content/gas_station_187.html

这道题只要看gas和是否小于cost和, 若小于则一定没有解, 反之则一定有解.
此时只要找到开头(即当前gas的值加上之前剩下的gas的值大于等于当前cost的值, 表示能够到达下一个station), 
看其到数组最后一个station中间的每个点是否都满足条件(当前gas的值加上之前剩下的gas的值大于等于当前cost的值), 
若满足则返回此开头, 否则从不满足的点的下一个点开始重新寻找开头. 因为一定有解, 则继续从下一个找
该问题属于贪心算法.
