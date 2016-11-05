public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
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
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}


// Non Recursion
class Solution {
  public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    int n = nums.length;
    Arrays.sort(nums);
    // O(2^n * n) 时间复杂度还是挺高的
    for (int i = 0; i < (1 << n); i++) {
      ArrayList<Integer> subset = new ArrayList<Integer>();
      for (int j = 0; j < n; j++) {
        // check whether the jth digit in i's binary representation is 1
        // if is 1, add the jth element into subset
        if ((i & (1 << j)) != 0) {
          subset.add(nums[j]);
        }
      }
      result.add(subset);
    }
    return result;
  }
}

// 1 << n is 2^n
// each subset equals to an binary integer between 0 .. 2^n - 1
// 0 -> 000 -> []
// 1 -> 001 -> [1]
// 2 -> 010 -> [2]
// 3 -> 011 -> [1,2]
// 4 -> 100 -> [3]
// 5 -> 101 -> [1,3]
// 6 -> 110 -> [2,3]
// 7 -> 111 -> [1,2,3]

/*
 * Given a set of distinct integers, return all possible subsets.
 *  Elements in a subset must be in non-descending order.
 *  The solution set must not contain duplicate subsets.
 *  Can you do it in both recursively and iteratively?
If S = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
真子集个数是2^n-1, 非空真子集个数是2^n-2
增加过程
[]
[1] [1,2] [1,2,3]
[1,3]
[2] [2,3]
[3]
]
最开始是r=[], list[], num, 0的问题, list加入到r  --1
然后根据pos和num.length, 产生了3个子问题
  list=[1], list=[2], list=[3]      --3
对于list=[1]的子问题, 根据pos和num.length会有2个子问题
  list=[1,2], list=[1,3]            --2
  而list=[1,2]的子问题, 还有一个子问题list=[1,2,3] --1
  而list=[1,3]因为pos＝3了, 不存在子问题了
同样list=[2]的子问题有[2,3]         --1
最后list=[3]也没有子问题了
*/
