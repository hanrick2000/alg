public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode helper(int[] preOrder, int preStart, int preEnd,
                            int[] inOrder,  int inStart,  int inEnd,
                            Map<Integer, Integer> map){
        if(preEnd < preStart){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int position = map.get(preOrder[preStart]);
        root.left = helper(preOrder, preStart + 1, preStart + position - inStart,
                           inOrder, inStart, position - 1, map);
        root.right = helper(preOrder, preStart + position - inStart + 1, preEnd,
                            inOrder, position + 1, inEnd, map);
        return root;
    }
}


/*
Given preorder and inorder traversal of a tree, construct the binary tree.
You may assume that duplicates do not exist in the tree.
Example
Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
  2
 / \
1   3

in-order:   4 2 5 (1) 6 7 3 8
pre-order: (1) 2 4 5  3 7 6 8
*/
