public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findLongest(root, 0, root.val - 1);
    }
    private int findLongest(TreeNode root, int length, int preVal){
        if(root == null){
            return length;
        }
        int currLen = -1;
        // 判断当前是否连续
        if(preVal + 1 == root.val){
            currLen = length + 1;
        }else{
            currLen = 1;
        }
        // 返回当前长度，左子树长度，和右子树长度中较大的那个
        int left_len = findLongest(root.left, currLen, root.val);
        int right_len = findLongest(root.right, currLen, root.val);
        return Math.max(currLen, Math.max(left_len, right_len)); 
    }
}




/*
Given a binary tree, find the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from 
some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).
For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not 3-2-1, so return 2.
Company Tags Google
Tags Tree
Similar Problems (H) Longest Consecutive Sequence
*/
