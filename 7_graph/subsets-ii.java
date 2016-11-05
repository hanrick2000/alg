public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);    
        subsetsHelper(result, list, num, 0); //把所有以list为开头的子集加到result中去, 从num的0位置开始
        return result;
    }
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<Integer>(list)); //注意new
        for (int i = pos; i < num.length; i++) {
            if(i != pos && num[i] == num[i - 1]){
                continue;
            }
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
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
