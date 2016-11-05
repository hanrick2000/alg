public class Solution {
    ArrayList<ArrayList<Integer> > ans;
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int K, int target) {
        ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tans = new ArrayList<Integer>();
        dfs(A, K, target, A.length - 1, tans);
        return ans;
    }
    public void dfs(int A[], int K, int target, int index, ArrayList<Integer> tans){
        if(K == 0 && target == 0) {
            ans.add(new ArrayList<Integer>(tans));
            return ;
        }
        if(K < 0 || target < 0 || index < 0){
            return;
        }
        dfs(A, K, target, index - 1, tans);
        tans.add(A[index]);
        dfs(A, K  - 1, target - A[index], index - 1, tans);
        tans.remove(tans.size() - 1);
        
    }
}
Given n unique integers, number k (1<=k<=n) and target.
Find all possible k integers where their sum is target.
Example
Given [1,2,3,4], k = 2, target = 5. Return:
[
  [1,4],
  [2,3]
]
