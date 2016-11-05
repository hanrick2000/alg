public class Solution {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null){
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if( a.val != b.val) {
            return false;
        }
        if (isIdentical(a.left, b.left) && isIdentical(a.right, b.right)) {
            return true;
        }
        return false;
    }
}

Check if two binary trees are identical. 
Identical means the two binary trees have the same structure and every identical position has the same value.

Example
    1             1
   / \           / \
  2   2   and   2   2
 /             /
4             4
are identical.


    1             1
   / \           / \
  2   3   and   2   3
 /               \
4                 4
are not identical.
