public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, path, 0, result);
        return result;
    }
    void helper(int[] candidates, int target, ArrayList<Integer> path, int pos, ArrayList<ArrayList<Integer>> result) {//把所有以path作为开头, 从pos开始, 和为target的所有解放入result中
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != pos && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], path, i + 1, result);
            path.remove(path.size() - 1);
        }
    }
}

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Notice
1 All numbers (including target) will be positive integers.
2 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3 The solution set must not contain duplicate combinations.

Example
Given candidate set [10,1,6,7,2,1,5] and target 8,

A solution set is:

[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]
Tags 
Backtracking Array Depth First Search
*/
