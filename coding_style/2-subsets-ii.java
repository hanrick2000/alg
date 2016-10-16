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
class Solution {
  public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    if ( S == null || S.size() == 0){
      return rst;
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    Collections.sort(S);
    helper(rst, list, S, 0);
    return rst;
  }
  
  public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list,
                     ArrayList<Integer> S, int pos) {
    rst.add(new ArrayList<Integer>(list));
    for (int i = pos; i < S.size(); i++){
      //跳过重复项
      if ( i != pos && S.get(i) == S.get(i-1)){
        continue;
      }
      list.add(S.get(i));
      helper(rst,list,S,i+1);
      list.remove(list.size()-1);
    }
  }
}
