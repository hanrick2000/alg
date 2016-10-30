class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                 int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int position = findPosition(inorder, instart, inend, postorder[postend]);
        root.left = myBuildTree(inorder, instart, position - 1,
                                postorder, poststart, poststart + position - instart - 1);
        root.right = myBuildTree(inorder, position + 1, inend,
                                 postorder, poststart + position - instart, postend - 1);
        return root;
    }
    private int findPosition(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}

Given inorder and postorder traversal of a tree, construct the binary tree.
You may assume that duplicates do not exist in the tree.
Example
Given inorder [1,2,3] and postorder [1,3,2], return a tree:
  2
 / \
1   3

in-order:   4 2 5  (1)  6 7 3 8
post-order: 4 5 2  6 7 8 3  (1)
