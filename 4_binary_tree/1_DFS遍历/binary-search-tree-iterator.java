class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;
    public BSTIterator(TreeNode root) {
        curt = root;
    }
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }
    public TreeNode next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        curt = stack.pop(); //因为有hasNext()保证, 要不curt不为空, 要不stack不为空, 如果curt为空, stack可以pop, 如果stack为空, curt一定不为空, 会在前面while中放入stack
        TreeNode node = curt;
        curt = curt.right;
        return node;
    }
}

Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.

Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
Challenge 
Extra memory usage O(h), h is the height of the tree.
Super Star: Extra memory usage O(1)
