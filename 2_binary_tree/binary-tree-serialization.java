class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) { //注意queue的size是随着增长的
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while (queue.get(queue.size() - 1) == null) { //去掉最后的null
            queue.remove(queue.size() - 1);
        }
        StringBuilder sb = new StringBuilder(); 
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>(); //队列中放的是待处理的节点
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (isLeftChild == false) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}


Design an algorithm and write code to serialize and deserialize a binary tree. 
Writing the tree to a file is called 'serialization' 
and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
There is no limit of how you deserialize or serialize a binary tree, 
you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
You can use other method to do serializaiton and deserialization.
