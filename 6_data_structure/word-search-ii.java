public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    //树节点包含isString，s和subTree属性。isString和s在节点为叶节点时保存字符串信息，subTree记录该节点的所有子节点（即该字符之后所有可能字符）。
    class TreeNode{
        boolean isString;
        String s;
        HashMap<Character, TreeNode> subTree;
        public TreeNode(){
            isString = false;
            s = "";
            subTree = new HashMap<Character, TreeNode>();
        }
    }
    //TrieTree包含root属性和insert，find方法。root为根节点。insert方法用于将一个新的字符串插入TrieTree，find方法用于判断一个字符串是否在TrieTree中。
    class TrieTree{
        TreeNode root;
        public TrieTree(TreeNode root){
            this.root = root;
        }

        public void insert(String word){
            TreeNode now = root;
            for(int i = 0; i < word.length(); i++){
                if(!now.subTree.containsKey(word.charAt(i))){
                    now.subTree.put(word.charAt(i), new TreeNode());
                }
                now = now.subTree.get(word.charAt(i));
            }
            //叶节点纪录该字符串并将isString赋值为true
            now.isString = true;
            now.s = word;
        }

        public boolean find(String word){
            TreeNode now = root;
            for(int i = 0; i < word.length(); i++){
                if(!now.subTree.containsKey(word.charAt(i))){
                    return false;
                }
            }
            return now.isString;
        }
    }

    //下右上左
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void search(int x, int y, char[][] board, TreeNode root, ArrayList<String> ans){
        //到达叶节点，判断该路径节点组成的字符串是否要加入答案链表。
        if(root.isString){
            if(!ans.contains(root.s)){
                ans.add(root.s);
            }
        }

        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || root == null){
            return;
        }

        //搜索当前字符四周字符，在搜索前将当前字符用'#'覆盖，以防重复搜索，在搜索完成后将其覆盖回原值。
        if(root.subTree.containsKey(board[x][y])){
            char curt = board[x][y];
            board[x][y] = '#';
            for(int i = 0; i < 4; i++){
                search(x + dx[i], y + dy[i], board, root.subTree.get(curt), ans);
            }
            board[x][y] = curt;
        }
    }

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> ans = new ArrayList<String>();

        TrieTree trie = new TrieTree(new TreeNode());
        //构建TrieTree
        for(int i = 0; i < words.size(); i++){
            trie.insert(words.get(i));
        }
        //对board中字符逐个搜索
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                search(i, j, board, trie.root, ans);
            }
        }

        return ans;
    }
}

用Trie结构来解题。
Trie树，又称单词查找树、字典树，是一种树形结构，是一种哈希树的变种，是一种用于快速检索的多叉树结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。Trie的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
三个基本特性：
1) 根节点不包含字符，除根节点外每一个节点都只包含一个字符。
2) 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
3) 每个节点的所有子节点包含的字符都不相同。
首先用TreeNode和TrieTree两个class来构建Trie结构。将words中所有word都加入TrieTree中生成字典树，叶节点保存从root到叶节点路径组成的字符串。然后对board中字符逐个扫描，看以该字符开头的单词是否能在TrieTree中找到。search方法递归地寻找当前字符邻接的字符是否在TrieTree中当前字符对应TreeNode的子树中。直到叶节点时，若该字符串未被加入过，则将该字符串加入答案链表。
Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 


Have you met this question in a real interview? Yes
Example
Given matrix:
doaf
agai
dcan
and dictionary:
{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}


dog:
doaf do
agai  g
dcan
dad:
doaf d
agai a
dcan d
can:
doaf
agai
dcan can
again:
doaf
agai agai
dcan    n
Challenge 
Using trie to implement your algorithm.
