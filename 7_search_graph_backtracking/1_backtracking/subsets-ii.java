public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return results;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);    
        subsetsHelper(results, list, num, 0); //把所有以list为开头的子集加到results中去, 从num的0位置开始
        return results;
    }
    private void subsetsHelper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list, int[] num, int startIndex) {
        results.add(new ArrayList<Integer>(list)); //注意new
        for (int i = startIndex; i < num.length; i++) {
            if(i != startIndex && num[i] == num[i - 1]){ //唯一增加的, 去重
                continue;
            }
            list.add(num[i]);
            subsetsHelper(results, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
/*
Given a list of numbers that may has duplicate numbers, return all possible subsets
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
If S = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
