public class Solution {
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) { //一个为null, 一个不为null
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        if (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) {
            return true;
        }
        if (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)) {
            return true;
        }
        return false;
    }
}

Check two given binary trees are identical or not. 
Assuming any number of tweaks are allowed. 
A tweak is defined as a swap of the children of one node in the tree.

There is no two nodes with the same value in the tree.

Example
    1             1
   / \           / \
  2   3   and   3   2
 /                 /  
4                 4    
are identical.


    1             1
   / \           / \
  2   3   and   3   2
 /                   \
4                     4
are identical.


    1             1
   / \           / \
  2   3   and   3   2
 /             /
4             4
are not identical.

Challenge 
O(n) time
