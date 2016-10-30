public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    private TreeNode myBuildTree(int[] inorder, int instart, int inend, 
                                 int[] preorder, int prestart, int preend) {
        if (instart > inend) { //处理[[], []], [[1,2],[1,2]]
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[prestart]); //找到root在in order中的位置
        //构建左子树
        root.left = myBuildTree(inorder, instart, position - 1, 
                                preorder, prestart + 1, prestart + position - instart);  //position - instart是左子树的长度
        //构建右子树
        root.right = myBuildTree(inorder, position + 1, inend, 
                                 preorder, prestart + position - instart + 1, preend); 
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


Given preorder and inorder traversal of a tree, construct the binary tree.
You may assume that duplicates do not exist in the tree.
Example
Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
  2
 / \
1   3

in-order:   4 2 5 (1) 6 7 3 8
pre-order: (1) 2 4 5  3 7 6 8
