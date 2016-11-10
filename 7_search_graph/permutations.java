public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results; 
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        //Arrays.sort(nums); //加不加无所谓
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(results, list, nums);
        return results;
    }
    public void helper(ArrayList<List<Integer>> results, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(results, list, nums);
            list.remove(list.size() - 1);
        }
    }
}

/*
 * 第一个版本你可以画一颗搜索树
 * 树的每一层就是递归的那一层 树上每个分支就是for循环中的每个选择
                       / 
              1        2         3   
           2    3   1    3    1    2
           3    2   3    1    2    1
 */

// Non-Recursion
class Solution {
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> permutations
       = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.size() == 0) {
      return permutations;
    }
    int n = nums.size();
    ArrayList<Integer> stack = new ArrayList<Integer>();
    stack.add(-1);
    while (stack.size() != 0) {
      Integer last = stack.get(stack.size() - 1);
      stack.remove(stack.size() - 1);
      // increase the last number
      int next = -1;
      for (int i = last + 1; i < n; i++) {
        if (!stack.contains(i)) {
          next = i;
          break;
        }
      }
      if (next == -1) {
        continue;
      }
      // generate the next permutation
      stack.add(next);
      for (int i = 0; i < n; i++) {
        if (!stack.contains(i)) {
          stack.add(i);
        }
      }
      // copy to permutations set
      ArrayList<Integer> permutation = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        permutation.add(nums.get(stack.get(i)));
      }
      permutations.add(permutation);
    }
    return permutations;
  }
}

遍历过程:
[1,2,3]
stack=[-1]
-
last=-1
stack=[]
next=-1
next=0
stack=[0]
stack=[0,1,2] ---1
-
last=2
stack=[0,1]
next=-1
-
last=1
stack=[0]
next=-1
next=2
stack=[0,2]
stack=[0,2,1]  ---2
-
last=1
stack=[0,2]
next=-1
-
last=2
stack=[0]
next=-1
-
last=0
stack=[]
next=-1
next=1
stack=[1]
stack=[1,0,2] ---3
-
last=2
stack=[1,0]
next=-1
-
last=0
stack=[1]
next=-1
next=2
stack=[1,2]
stack=[1,2,0] ---4
-
last=0
stack=[1,2]
next=-1
-
last=2
stack=[1]
-
last=1
stack=[]
next=2
stack=[2]
stack=[2,0,1] ---5
-
last=1
stack=[2,0]
next=-1
-
last=0
stack=[2]
next=-1
next=1
stack=[2,1]
stack=[2,1,0] ---6
-
last=0
stack=[2,1]
next=-1
-
last=1
stack=[2]
next=-1
-
last=2
stack=[]
next=-1
-



[1,2,3,4]
stack=[-1]
-
last=-1
stack=[]
next=0
stack=[0,1,2,3] ----1
-
last=3
stack=[0,1,2]
next=-1
-
last=2
stack=[0,1]
next=3
stack=[0,1,3,2]  ----2
-
last=2
stack=[0,1,3]
next=-1
-
last=3
stack=[0,1]
next=-1
-
last=1
stack=[0]
next=2
stack=[0,2,1,3] ----3
-
last=3
stack=[0,2,1]
next=-1
-
last=1
stack=[0,2]
next=3
stack=[0,2,3,1] ----4
-
last=1
stack=[0,2,3]
next=-1
-
last=3
stack=[0,2]
next=-1
-
last=2
stack=[0]
next=3
stack=[0,3,1,2] ----5
-
last=2
stack=[0,3,1]
next=-1
-
last=1
stack=[0,3]
next=2
stack=[0,3,2,1]  ----6
-
last=1
stack=[0,3,2]
next=-1
-
last=2
stack=[0,3]
next=-1
-
last=3
stack=[0]
next=-1
-
last=0
stack=[]
next=1
stack=[1,0,2,3] ----7
-
last=3
stack=[1,0,2]
next=-1
-
last=2
s=[1,0]
next=3
s=[1,0,3,2]  -----8
-
last=2
stack=[1,0,3]
next=-1
-
last=3
stack=[1,0]
next=-1
-
last=0
stack=[1]
next=1
stack=[1,2,0,3] ----9
-
last=3
stack=[1,2,0]
next=-1
-
last=0
stack=[1,2]
next=3
stack=[1,2,3,0] ----10
-
last=0
stack=[1,2,3]
next=-1
-
last=3
stack=[1,2]
next=-1
-
last=2
stack=[1]
next=3
stack=[1,3,0,2] ----11
-
last=2
stack=[1,3,0]
next=-1
-
last=0
stack=[1,3]
next=2
stack=[1,3,2,0] ----12
-
last=0
stack=[1,3,2]
next=-1
-
last=2
stack=[1,3]
next=-1
-
last=3
stack=[1]
next=-1
-
last=1
stack=[]
next=2
stack=[2,0,1,3] ----13
-
stack=[2,0,3,1] ----14
stack=[2,1,0,3] ----15
stack=[2,1,3,0] ----16
stack=[2,3,0,1] ----17
stack=[2,3,1,0] ----18
stack=[3,0,1,2] ----19
stack=[3,0,2,1] ----20
stack=[3,1,0,2] ----21
stack=[3,1,2,0] ----22
stack=[3,2,0,1] ----23
stack=[3,2,1,0] ----24
-
last=0
stack=[3,2,1]
next=-1
-
last=1
stack=[3,2]
next=-1
-
last=2
stack=[3]
next=-1
-
last=3
stack=[]
next=-1
-

/*
 * Given a list of numbers, return all possible permutations.
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Do it without recursion.
*/

/*
加入顺序
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
*/

