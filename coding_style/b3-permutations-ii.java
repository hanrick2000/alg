/*
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * For numbers [1,2,2] the unique permutations are:
[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
 */
public class Solution {
  public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(nums == null || nums.size() == 0)
      return result;
    ArrayList<Integer> list = new ArrayList<Integer>();
    int[] visited = new int[nums.size()];
    
    Collections.sort(nums);
    helper(result, list, visited, nums);
    return result;
  }
  
  public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, ArrayList<Integer> nums) {
    if(list.size() == nums.size()) {
      result.add(new ArrayList<Integer>(list));
      return;
    }
    
    for(int i = 0; i < nums.size(); i++) {
      if (visited[i] == 1 || (i != 0 && nums.get(i) == nums.get(i-1) && visited[i - 1] == 0)){
        continue;
    /*
      上面的判断主要是为了去除重复元素影响。
      比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
      我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
      当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
      不应该让后面的2使用。
    */
      }
      visited[i] = 1;
      list.add(nums.get(i));
      helper(result, list, visited, nums);
      list.remove(list.size() - 1);
      visited[i] = 0;
    }
  }  
}
