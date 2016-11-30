//Union Find
class UnionFind {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public UnionFind(HashSet<Integer> set){
        for (Integer i: set) {
            map.put(i, i);
        }
    }
    int find(int x){
        int parent = map.get(x);
        while (parent != map.get(parent)) {
            parent = map.get(parent);
        }
        int next;
        while (x != map.get(x)) {
            next = map.get(x);
            map.put(x, parent);
            x = next;
        }
        return parent;
    }
    void union(int x, int y){
        int fa_x = find(x);
        int fa_y = find(y);
        map.put(fa_x, fa_y);
    }
}

// 图的BFS
// 有一个node
Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
HashSet<UndirectedGraphNode> set = new HashSet<>();
queue.offer(node);
set.add(node);
while (!queue.isEmpty()) {
    UndirectedGraphNode head = queue.poll();
    //可能会做些什么
    for (UndirectedGraphNode neighbor : head.neighbors) {
        if(!set.contains(neighbor)){
            set.add(neighbor);
            queue.offer(neighbor);
        }
    }
}

//图的topology sorting
public class Solution {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}

// Backtracking
先对condidates排序
void helper(int[] candidates, int target, ArrayList<Integer> path, int pos, ArrayList<ArrayList<Integer>> result) {//把所有以path作为开头, 从pos开始, 和为target的所有解放入result中
    if (target == 0) {
        result.add(new ArrayList<Integer>(path)); //加入结果集
        return;
    }
    for (int i = pos; i < candidates.length; i++) {
        if (candidates[i] > target) { //提前结束
            break;
        }
        if (i != pos && candidates[i - 1] == candidates[i]) { //不要重复的
            continue;
        }
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], path, i, result);
        path.remove(path.size() - 1);
    }
}

// Binary Search
int start = 0;
int end = nums.length - 1;
while (start + 1 < end) {
    int mid = start + (end - start) / 2;
    if (nums[mid] == target) {
        //start = mid; last  position
        //end = mid;   first position
    } else if (nums[mid] < target) {
        start = mid;
    } else if (nums[mid] > target{
        end = mid;
    }
}
if (nums[end] == target) {
    return end;
}
if (nums[start] == target) {
    return start;
}
return -1;


// Binary Tree Traversal Recursion
public ArrayList<Integer> preorderTraversal(TreeNode root) { //汇报工作
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
        return result;
    }
    // Divide
    ArrayList<Integer> left = preorderTraversal(root.left);
    ArrayList<Integer> right = preorderTraversal(root.right);
    // Conquer
    result.add(root.val);
    result.addAll(left);
    result.addAll(right);
    return result;
}

// Binary Tree Traversal Non Recursion
// Pre Order
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
        return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);                        //最开始root入栈
    while (stack.empty() == false) {         //只要栈非空
        TreeNode node = stack.pop();         //栈顶出栈
        result.add(node.val);                //放入结果
        if (node.right != null) {            //把右节点放入栈
            stack.push(node.right);
        }
        if (node.left != null) {             //把左节点放入栈
            stack.push(node.left);
        }
    }
    return result;
}

// In Order
public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if(root == null){
        return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (true) {
        while(root != null){      //先沿着左子树遍历到头, 放入stack
            stack.push(root);
            root = root.left;
        }
        if(stack.isEmpty()){      //只要stack非空
            return result;
        }
        root = stack.pop();       //取出栈顶元素
        result.add(root.val);     //放入结果
        root = root.right;        //考虑右子树
    }
}

// Post Order
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null){
        return result;
    }
    Stack<TreeNode> s1 = new Stack<TreeNode>();
    Stack<TreeNode> s2 = new Stack<TreeNode>();
    s1.push(root);                             //类似preorder,先把root放入栈里
    while (s1.isEmpty() == false) {
        TreeNode node = s1.pop();              //取出栈顶元素, 放入s2中, preorder是直接放入了结果集
        s2.push(node);
        if(node.left != null){                 //注意, 这里与preorder时顺序相反
            s1.push(node.left);
        }
        if(node.right != null){
            s1.push(node.right);
        }
    }
    while(s2.isEmpty() == false){
        result.add(s2.pop().val);              //s2逐个出栈放入结果集
    }
    return result;
}

// 树的BFS
Queue<TreeNode> queue = new LinkedList<TreeNode>();
queue.offer(root); //先入队root
while (!queue.isEmpty()) {
    ArrayList<Integer> level = new ArrayList<Integer>();
    int size = queue.size(); //更新size
    for (int i = 0; i < size; i++) {
        TreeNode head = queue.poll(); //出队
        level.add(head.val);
        if (head.left != null) { //按照先左后右的顺序依次入队
            queue.offer(head.left); //入队
        }
        if (head.right != null) {
            queue.offer(head.right); //入队
        }
    }
    result.add(level); //把一层结果加入结果集
}

// Partition list
public ListNode partition(ListNode head, int x) {
    if (head == null){
        return null;
    }
    ListNode leftDummy = new ListNode(0);
    ListNode rightDummy = new ListNode(0);
    ListNode left = leftDummy; //表示left的当前位置
    ListNode right = rightDummy; //表示right的当前位置
    while (head != null) {
        if (head.val < x) {
            left.next = head;
            left = head;
        } else {
            right.next = head;
            right = head;
        }
        head = head.next;
    }
    right.next = null; //这句必须有哦, 要不然会有环产生
    left.next = rightDummy.next;
    return leftDummy.next;
}

// Merge list
private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            tail.next = list1;
            list1 = list1.next;
        } else {
            tail.next = list2;
            list2 = list2.next;
        }
        tail = tail.next;
    }
    if (list1 != null) {
        tail.next = list1;
    } else {
        tail.next = list2;
    }
    return dummy.next;
}

// Find mid of list
public ListNode findMid(ListNode head){
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

// Reverse of list
public ListNode reverse(ListNode head){
    ListNode newHead = null;
    while(head != null) {
        ListNode temp = head.next;
        head.next = newHead;
        newHead = head;
        head = temp;
    }
    return newHead;
}

// Merge k sorted lists: Priority Queue (Heap) 
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator); //PQ用法, 初始化指定大小, 以及元素的comparator
        for (int i = 0; i < lists.size(); i++) { //先把k路链表的头放入min-heap中
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll(); //PQ出堆, 然后放入下一个元素
            tail.next = head; //把出堆元素连接到结果list中
            tail = tail.next;
            if (head.next != null) {//如果还有元素没有遍历, 继续放入heap中
                heap.add(head.next);
            }
        }
        return dummy.next;
    }
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() { //Min heap
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
}
