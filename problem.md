OK===E  二分位置======================== www.lintcode.com/problem/classical-binary-search ======================================= Binary Search  
OK   E  二分位置                         www.lintcode.com/problem/first-position-of-target  
OK   E  二分位置                         www.lintcode.com/problem/search-insert-position   
OK   E  二分位置                         www.lintcode.com/problem/last-position-of-target  
OK   M  二分位置                         www.lintcode.com/problem/search-in-a-big-sorted-array  
OK   E  二分位置                         www.lintcode.com/problem/search-a-2d-matrix  
OK   M  二分位置                         www.lintcode.com/problem/search-a-2d-matrix-ii  
OK   M  二分位置                         www.lintcode.com/problem/find-minimum-in-rotated-sorted-array  
OK   M  二分位置                         www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii  
OK   M  二分位置                         www.lintcode.com/problem/search-in-rotated-sorted-array  
OK   M  二分位置                         www.lintcode.com/problem/search-in-rotated-sorted-array-ii TODO: 都用end作为标签  
OK   M  二分位置                         www.lintcode.com/problem/search-for-a-range  
OK   E  二分位置                         www.lintcode.com/problem/total-occurrence-of-target 寻找大于target的最小值所在的位置, 注意判断返回的是数组两边的位置  
OK   E  二分位置                         www.lintcode.com/problem/closest-number-in-sorted-array 找到大于target的最小元素  
OK * M  二分位置  两个指针               www.lintcode.com/problem/k-closest-numbers-in-sorted-array 先找到大于target的最小元素, 然后找这个元素周围最近的k个  
OK   M  二分答案                         www.lintcode.com/problem/first-bad-version  
OK   E  二分答案                         www.lintcode.com/problem/sqrtx  
OK   M  二分答案                         www.lintcode.com/problem/wood-cut 先确定一个木头长度的上界, 根据是否满足最少获得的木头个数, 然后二分的方法缩小  
OK   M  保留有解的一半                   www.lintcode.com/problem/find-peak-element  
O    M                                   www.lintcode.com/problem/maximum-number-in-mountain-sequence
O    M                                   www.lintcode.com/problem/divide-two-integers
OK===E  DFS遍历 递归+非递归============= www.lintcode.com/problem/binary-tree-preorder-traversal 需栈,根先入栈,然后while循环栈顶出栈加入结果,按照先右后左的顺序放入栈====Binary Tree & Divide Conquer  
OK   M  DFS遍历 递归+非递归              www.lintcode.com/problem/binary-tree-inorder-traversal 需要栈, 最外while循环, 内层先while循环左子树遍历入栈, 栈若空返回结果, 否则栈顶出栈加入结果, 检查右子树  
OK   E  DFS遍历 递归+非递归              www.lintcode.com/problem/binary-tree-postorder-traversal 类似先序, 需要两个栈, 栈顶元素出栈后加入另一个栈, 先左后右, 最后栈2出栈到结果集  
OK   H  DFS遍历 中序遍历 记忆            www.lintcode.com/problem/binary-search-tree-iterator 类似中序遍历, hasNext看curt和栈是否为空, next()是中序的while循环内部  
OK   M  DFS遍历 中序思想 记忆            www.lintcode.com/problem/inorder-successor-in-binary-search-tree 先找到node, 如果node右儿子是空, 则node的parent就是前继, 否则是右儿子的最左叶子是前继  
OK   M  DFS遍历 中序剪枝遍历 改非递归    www.lintcode.com/problem/search-range-in-binary-search-tree 中序遍历, 提前结束; 非递归类似Traversal的中序遍历, 带上剪枝  
OK   E  DFS遍历 非递归                   www.lintcode.com/problem/insert-node-in-a-binary-search-tree 递归的很容易理解; 根据当前root和target比较决定向左右哪个儿子前进, 知道遇到某儿子是空时  
OK * H  DFS遍历 3中情况                  www.lintcode.com/problem/remove-node-in-binary-search-tree 先找到要删除的节点的parent, 以及这个节点, 然后根据儿子的数量分3中情况来删除  
OK   E  DFS遍历 路径和是target的所有路径 www.lintcode.com/problem/binary-tree-path-sum 递归  
OK   E  DFS遍历 两棵树                   www.lintcode.com/problem/tweaked-identical-binary-tree 三个递归退出条件, 两种递归拆解情况  
OK   E  DFS遍历 两棵树                   www.lintcode.com/problem/identical-binary-tree 三个递归退出条件, 1个递归拆解情况  
OK   E  DFS遍历 一棵树                   www.lintcode.com/problem/symmetric-binary-tree 先拆左右树, 三个递归退出条件, 1个递归拆解情况  
OK * E  DFS遍历 一棵树 概念题            www.lintcode.com/problem/complete-binary-tree 定义helper返回Result(深度,Complete,Full); 得到左右子树, 左子树必须是C, 深度相同时, 左F右C, 深度左高右低, 左C右F  
OK   M  DFS遍历 利用pre找到分割in的位置  www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal 递归定义: 返回从start到end的树的根节点, 找到切分的位置, 拆解递归  
OK   M  DFS遍历                          www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal  
OK   E  DivideConquer                    www.lintcode.com/problem/maximum-depth-of-binary-tree 递归;   
OK * E  DivideConquer                    www.lintcode.com/problem/minimum-depth-of-binary-tree 一定要达到leaf: root空;1个儿子空;2个儿子为空;2个儿子不为空  
OK   E  DivideConquer                    www.lintcode.com/problem/balanced-binary-tree 递归定义: 返回当前root的高度, -1是不平衡  
OK   M  DivideConquer  挺难              www.lintcode.com/problem/lowest-common-ancestor 递归定义: 返回以当前root为根, 两个node的祖先, 根据左右子树拆解, 结束条件是遇到一个节点就放会  
OK   E  先得到Path,然后沿着Path找        www.lintcode.com/problem/lowest-common-ancestor-ii  
OK   M  DivideConquer                    www.lintcode.com/problem/binary-tree-maximum-path-sum-ii 从根出发的最大路径, 不一定到叶子  
OK * M  DivideConquer maxPath一定包含值  www.lintcode.com/problem/binary-tree-maximum-path-sum 递归定义:返回root的Result(singlePath, maxPath), maxPath是树内anytoany, singlePath是从根开始  
OK   M  DivideConquer                    www.lintcode.com/problem/validate-binary-search-tree 递归定义:返回root的Result(is_bst, min, max), 根据左右子树进行拆解, 先观察子树, 再结合root的值  
OK   M  BFS遍历 1队列,root入队,进入while www.lintcode.com/problem/binary-tree-level-order-traversal 根据当前队列长度for循环, 把队列元素出队, 把元素子树放入队列, 完成一次for循环加入一次结果集  
OK   M  BFS遍历 从下向上                 www.lintcode.com/problem/binary-tree-level-order-traversal-ii Collections.reverse()  
OK   M  BFS遍历 两个stack版本            www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal normalOrder决定当前层顺序  
OK   M  BFS遍历 deserial时用一个queue    www.lintcode.com/problem/binary-tree-serialization index指出当前处理那个node,当处理完左右时index增,ser:先把所有节点按层序入queue, 去掉最后的null, 按顺序输出.  
O    E                                   www.lintcode.com/problem/sort-integers-ii
O    M                                   www.lintcode.com/problem/expression-expand
OK===E  坐标型 ========================= www.lintcode.com/problem/unique-paths-ii ======================================= Dynamic Program  
OK   E  坐标型                           www.lintcode.com/problem/unique-paths 从矩形左上角走到右下角的方案数  
OK   E  坐标型                           www.lintcode.com/problem/climbing-stairs 从1层到顶层的爬楼梯方法  
OK   E  坐标型                           www.lintcode.com/problem/minimum-path-sum 从矩形左上角到右下角的最小路径长度  
OK   E  坐标型     滚动数组              www.lintcode.com/problem/triangle 从根到叶子的最小路径长度  
OK   M  坐标型     贪心                  www.lintcode.com/problem/jump-game-ii 从起点到达终点的最小跳数  
OK   M  坐标型     贪心                  www.lintcode.com/problem/jump-game 从起点能否到达终点  
OK   M  坐标型                           www.lintcode.com/problem/longest-increasing-subsequence 最长的递增子序列长度  
OK   M  单-序列型                        www.lintcode.com/problem/house-robber 在一个条状小区内最大的偷盗价值  
OK   M  单-序列型  拆环                  www.lintcode.com/problem/house-robber-ii 在一个环状小区内最大的偷盗价值  
OK   M  单-序列型                        www.lintcode.com/problem/word-break 字符串能否用字典分割
OK   M  单-序列型                        www.lintcode.com/problem/palindrome-partitioning-ii 得到最少的回文串需要切几刀  
OK   E  单-序列型  贪心 presum           www.lintcode.com/problem/maximum-subarray 连续数组的最大和  
OK   M  单-序列型                        www.lintcode.com/problem/decode-ways 解码方案数 chatAt(x)  
OK   M  单-序列型                        www.lintcode.com/problem/maximum-product-subarray 连续数组的最大积  
OK   M  双序列型                         www.lintcode.com/problem/edit-distance 最少的编辑次数  
OK   M  双序列型                         www.lintcode.com/problem/distinct-subsequences 不同的子序列个数  
OK   M  双序列型                         www.lintcode.com/problem/interleaving-string 字符串A和字符串B能否交替的组成字符串C  
OK   M  双序列型                         www.lintcode.com/problem/longest-common-substring 字符串A和字符串B的最长连续公共子串  
OK   M  双序列型                         www.lintcode.com/problem/longest-common-subsequence 字符串A和字符串B的最长公共子序列  
OK   H  双序列型                         www.lintcode.com/problem/wildcard-matching 字符串S是否能被带*?的字符串P匹配上  
OK   E  记忆化搜索 引子题                www.lintcode.com/problem/longest-increasing-continuous-subsequence  数组的LICS长度  
OK * H  记忆化搜索                       www.lintcode.com/problem/longest-increasing-continuous-subsequence-ii 矩形的LICS  
OK   M  记忆化搜索                       www.lintcode.com/problem/coins-in-a-line 选手可以拿1个或两个硬币, 拿到最后的算赢, 先手能否赢  
OK   M  记忆化搜索                       www.lintcode.com/problem/coins-in-a-line-ii 一个人可以拿1个或两个硬币, 每个硬币价值不同, 拿到价值多的赢, 先手能否赢  
OK   H  记忆化搜索                       www.lintcode.com/problem/coins-in-a-line-iii 可以从头或者尾拿1个硬币, 每个硬币价值不同, 拿到价值多的赢, 先手能否赢 TODO 非递归版  
OK   M  记忆化搜索 区间DP                www.lintcode.com/problem/stone-game   
OK   H  记忆化搜索                       www.lintcode.com/problem/scramble-string s.toCharArray()  
OK   H  记忆化搜索 区间DP                www.lintcode.com/problem/burst-balloons  
OK   M  背包                             www.lintcode.com/problem/backpack 背包容量是m, 每个物品体积不同, 最大放多少体积, i从1到n, j从1到target  
OK   M  背包                             www.lintcode.com/problem/backpack-ii 背包容量是m, 每个物品价值不同, 最大放多少价值  
OK   H  背包                             www.lintcode.com/problem/backpack-iii 背包容量是m, 每个物品价值不同, 物品可以重复放, 最大放多少价值  
OK   M  背包                             www.lintcode.com/problem/backpack-iv 背包容量是m, 每个物品体积不同, 物品可以重复, 放满背包的方案数, f[0][0]=1 j要从0开始到target  
OK   M  背包                             www.lintcode.com/problem/backpack-v 背包容量是m, 每个物品体积不同, 放满背包的方案数, f[0][0]=1 j要从0开始到target  
OK   M  背包                             www.lintcode.com/problem/backpack-vi 背包容量是m, 每个物品体积不同, 放满背包的组合方案数, 1维状态 f[i] += f[i - nums[j]]  
OK * H  背包                             www.lintcode.com/problem/k-sum 第i个数取还是不取 f[i][j][t] = f[i-1][j][t] or f[i-1][j][t] + f[i-1][j-1][t-A[i-1]]  
OK * M  背包 给一个数组和一个target      www.lintcode.com/problem/minimum-adjustment-cost f[i][j]表示前i个数, 第i个数调整成j, 所需要的最小代价.计算f[i][j]时,3重循环,最内层要枚举第i-1个数时的各种情况  
OK * H  背包                             www.lintcode.com/problem/copy-books f[i][j]表示前i本书分配给j个人的最小cost, 三重循环, 最内层枚举新加进来的人处理多少本书  
OK * H  背包                             www.lintcode.com/problem/copy-books-ii f[i][j]表示前i个人分配给前j本书的最小cost, 三重循环, 最内层枚举新加进来的人处理多少本书  
OK   M  经典题                           www.lintcode.com/problem/maximal-square 想要RA优化空间, 随着for循环初始化首行和首列  
OK   M  区间型                           www.lintcode.com/problem/longest-palindromic-substring  
O    H                                   www.lintcode.com/problem/post-office-problem  
O    H                                   www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iv  
OK   E                                   www.lintcode.com/problem/drop-eggs
OK   M                                   www.lintcode.com/problem/drop-eggs-ii
OK===M  使用dummy 如果head.next的值和=== www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii head.next.next的值相等, 那么记录这个值, 循环删除所有等于这个值的node========== LinkedList  
OK   E  用HashSet记录访问过的node, dummy www.lintcode.com/problem/remove-duplicates-from-unsorted-list 用了dummy的, while都是判断head.next不为空  
OK   E                                   www.lintcode.com/problem/remove-duplicates-from-sorted-list node指向head,如果node.next不为空,那么判断下node的值和node.next的值是否相等,相等就删掉node.next  
OK   E  基本操作:reverse  preNode        www.lintcode.com/problem/reverse-linked-list 用preNode  
OK   M  画图, dummy                      www.lintcode.com/problem/reverse-linked-list-ii  
OK   E  基本操作:partition               www.lintcode.com/problem/partition-list 用两个dummy指针和两个移动指针  
OK   E  基本操作:remove                  www.lintcode.com/problem/remove-linked-list-elements dummy指针  
OK   E  基本操作:merge                   www.lintcode.com/problem/merge-two-sorted-lists dummy是个空指针, 开始lastNode指向dummy, 随着merge移动lastNode  
OK   E  基本操作:middle                  www.lintcode.com/problem/middle-of-linked-list slow + fast  
OK * M  middle,partition,merge           www.lintcode.com/problem/sort-list MergeSort:findMiddle->sort_right+sort_left->merge; QuickSort:findMiddle->partition(L/M/R)->sort_left+sort_right->concat  
OK   M  reverse,merge,middle             www.lintcode.com/problem/reorder-list findMiddle->reverse(mid.next)->merge  
OK   M  前向型指针 快慢类                www.lintcode.com/problem/linked-list-cycle  
OK   H  前向型指针 快慢类                www.lintcode.com/problem/linked-list-cycle-ii slow fast先移动相遇后再移动head和slow, while(head != slow.next) 最后返回head就是环出现的地方  
OK   E  前向型指针 快慢类                www.lintcode.com/problem/remove-nth-node-from-end-of-list dummy, preDelete  
OK * M  三种方法都要掌握                 www.lintcode.com/problem/merge-k-sorted-lists Diveide&Conquer; 两两合并; PriorityQueue(min-heap)  
OK   M  HashMap; No extra space          www.lintcode.com/problem/copy-list-with-random-pointer 先copyNext -> 再copyRandom -> 最后Split  
OK   E  删除中间的一个节点               www.lintcode.com/problem/delete-node-in-the-middle-of-singly-linked-list  
OK   M  先得到长度, 然后先递归得到左子树 www.lintcode.com/problem/convert-sorted-list-to-balanced-bst 然后再构造跟, 移动current, 递归构造右子树, 组合左右子树, 最后返回根  
OK   M  helper(root)返回当前BST树的      www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list 最小值的node和最大值的node, 递归的得到左右子树的result, 利用它门构造当前根的result  
OK   H  每次reverseK, 每次先看是否够长   www.lintcode.com/problem/reverse-nodes-in-k-group 确定n1, prev, cur的位置, 然后进行k-1次的翻转操作, 最后做首尾的调整, 画图很重要  
O    E                                   www.lintcode.com/problem/swap-nodes-in-pairs  
O    E                                   www.lintcode.com/problem/insertion-sort-list  
O    E                                   www.lintcode.com/problem/add-two-numbers  
O    M                                   www.lintcode.com/problem/add-two-numbers-ii  
O    E                                   www.lintcode.com/problem/nth-to-last-node-in-list  
O    M                                   www.lintcode.com/problem/swap-two-nodes-in-linked-list  
O    M                                   www.lintcode.com/problem/palindrome-linked-list  
O ===E  ================================ www.lintcode.com/problem/intersection-of-two-arrays ============================ Array&Numbers  
O    E                                   www.lintcode.com/problem/subarray-sum  
O    E                                   www.lintcode.com/problem/merge-sorted-array  
O    M                                   www.lintcode.com/problem/two-sum-closest  
O    M                                   www.lintcode.com/problem/subarray-sum-closest  
O    H                                   www.lintcode.com/problem/median-of-two-sorted-arrays  
O    E                                   www.lintcode.com/problem/minimum-subarray  
OK   E                                   www.lintcode.com/problem/merge-two-sorted-arrays  
O    M                                   www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii  
O    M                                   www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii  
O    M                                   www.lintcode.com/problem/best-time-to-buy-and-sell-stock  
O    M                                   www.lintcode.com/problem/maximum-subarray-difference  
O    M                                   www.lintcode.com/problem/maximum-subarray-ii  
O    H                                   www.lintcode.com/problem/maximum-subarray-iii  
O ===E  ================================ www.lintcode.com/problem/hash-function ========================================= Data Structure  
O    M                                   www.lintcode.com/problem/top-k-largest-numbers  
O    M                                   www.lintcode.com/problem/merge-k-sorted-arrays  
O    M                                   www.lintcode.com/problem/rehashing  
OK   M                                   www.lintcode.com/problem/implement-queue-by-two-stacks  
O    M                                   www.lintcode.com/problem/min-stack  
O    M                                   www.lintcode.com/problem/ugly-number-ii  
OK   H                                   www.lintcode.com/problem/lru-cache  
O    H                                   www.lintcode.com/problem/largest-rectangle-in-histogram  
O    E                                   www.lintcode.com/problem/implement-stack  
O    E                                   www.lintcode.com/problem/implement-stack-by-two-queues  
O    E                                   www.lintcode.com/problem/implement-queue-by-linked-list-ii  
O    E                                   www.lintcode.com/problem/implement-queue-by-linked-list  
O    M                                   www.lintcode.com/problem/top-k-largest-numbers-ii  
O    M                                   www.lintcode.com/problem/stack-sorting  
O    M                                   www.lintcode.com/problem/top-k-frequent-words  
O    M                                   www.lintcode.com/problem/heapify  
O    M                                   www.lintcode.com/problem/longest-consecutive-sequence  
O    H                                   www.lintcode.com/problem/animal-shelter  
O    H                                   www.lintcode.com/problem/lfu-cache  
O    H                                   www.lintcode.com/problem/max-tree  
O    M                                   www.lintcode.com/problem/implement-three-stacks-by-single-array
OK===M BackTracking ==================== www.lintcode.com/problem/subsets =========================================== Graph & Search & BackTracking 
OK   M BackTracking                      www.lintcode.com/problem/subsets-ii  
OK   M BackTracking                      www.lintcode.com/problem/permutations  
OK   M BackTracking                      www.lintcode.com/problem/permutations-ii  
O    M BackTracking                      www.lintcode.com/problem/palindrome-partitioning  
OK   H BackTracking                      www.lintcode.com/problem/word-ladder-ii  
OK   H BackTracking                      www.lintcode.com/problem/word-break-ii 跟permutation很像, 利用word-break来避免搜索不肯能的
O    M BackTracking                      www.lintcode.com/problem/k-sum-ii  
OK   M BackTracking                      langford-pairing
O    M BackTracking                      www.lintcode.com/problem/combination-sum  
OK   M BackTracking                      www.lintcode.com/problem/letter-combinations-of-a-phone-number StringBuilder.append() StrinbBuilder.deleteCharAt()
O    M                                   www.lintcode.com/problem/clone-graph  
OK   M                                   www.lintcode.com/problem/word-ladder  
OK   M                                   www.lintcode.com/problem/six-degrees   
O    M                                   www.lintcode.com/problem/topological-sorting  
O    M                                   www.lintcode.com/problem/n-queens  
O    M                                   www.lintcode.com/problem/n-queens-ii  
O    M                                   www.lintcode.com/problem/string-permutation-ii  
OK===E  UF  ============================ www.lintcode.com/problem/number-of-islands ===================================== UnionFind/Trie/SweepLine/Heap/HashHeep/Deque  
O    H  UF                               www.lintcode.com/problem/number-of-islands-ii  
OK   M  UF                               www.lintcode.com/problem/graph-valid-tree  
O    M  UF                               www.lintcode.com/problem/find-the-weak-connected-component-in-the-directed-graph  
O    M  UF                               www.lintcode.com/problem/find-the-connected-component-in-the-undirected-graph  
O    M  UF                               www.lintcode.com/problem/surrounded-regions  
O    M  SweepLine                        www.lintcode.com/problem/number-of-airplanes-in-the-sky  
O    M  Trie                             www.lintcode.com/problem/add-and-search-word  
O    M                                   www.lintcode.com/problem/word-search  
O    H  Trie                             www.lintcode.com/problem/word-search-ii  
O    M  SegmentTree                      www.lintcode.com/problem/segment-tree-query-ii  
O    H                                   www.lintcode.com/problem/kth-smallest-sum-in-two-sorted-arrays  
O    H  SegmentTree                      www.lintcode.com/problem/count-of-smaller-number-before-itself  
O    H  SegmentTree                      www.lintcode.com/problem/interval-sum-ii  
O    H                                   www.lintcode.com/problem/trapping-rain-water-ii   
O    H                                   www.lintcode.com/problem/sliding-window-median  
O    H                                   www.lintcode.com/problem/data-stream-median  
O    S                                   www.lintcode.com/problem/building-outline  
O    S                                   www.lintcode.com/problem/sliding-window-maximum  
O    H                                   www.lintcode.com/problem/maximal-rectangle  
O    H                                   www.lintcode.com/problem/expression-tree-build  
O    H                                   www.lintcode.com/problem/convert-expression-to-reverse-polish-notation  
O    H                                   www.lintcode.com/problem/convert-expression-to-polish-notation  
O    H                                   www.lintcode.com/problem/expression-evaluation  
OK===M  对撞型指针 2-sum类 ============= www.lintcode.com/problem/container-with-most-water ==================================== Two Pointers  
OK   M  对撞型指针 2-sum类               www.lintcode.com/problem/trapping-rain-water  
OK   M  对撞型指针 2-sum类               www.lintcode.com/problem/two-sum  
OK   M                                   www.lintcode.com/problem/two-sum-ii  
OK   M  对撞型指针 2-sum类               www.lintcode.com/problem/3sum-closest 固定一个数, 然后左右缩减范围  
OK   M  对撞型指针 2-sum类               www.lintcode.com/problem/3sum 也是固定一个数, 但注意当遇到相同值时, bypass它  
OK   M  对撞型指针 2-sum类               www.lintcode.com/problem/4sum  
OK   H  对撞型指针 2-sum类               www.lintcode.com/problem/triangle-count  
OK   M  对撞型指针 partition类           www.lintcode.com/problem/nuts-bolts-problem   
OK * M  对撞型指针 partition类           www.lintcode.com/problem/kth-largest-element  
OK   E  对撞型指针 partition类           www.lintcode.com/problem/valid-palindrome front>=end; Character.isDigit(), Character.isLetter()  
OK   E  对撞型指针 partition类           www.lintcode.com/problem/partition-array-by-odd-and-even 一遍直接翻转  
OK   M  对撞型指针 partition类           www.lintcode.com/problem/sort-letters-by-case 一遍直接翻转, Character.isUpperCase(), Character.isLowerCase()  
OK * M  对撞型指针 partition类           www.lintcode.com/problem/partition-array 一遍直接翻转 感觉所有此类题跟另外一种partition都可以用一种partition的模板搞定  
OK   M  对撞型指针 partition类           www.lintcode.com/problem/sort-colors 画图 Left Cur Right  
OK   M  对撞型指针 partition类           www.lintcode.com/problem/interleaving-positive-and-negative-numbers  
OK * M  前向型指针 窗口类                www.lintcode.com/problem/minimum-size-subarray-sum 求最短的连续子数组的和>=s  
OK   M  前向型指针 窗口类                www.lintcode.com/problem/minimum-window-substring 求在Source中最短的包含了Target所有字符的子串  
OK * M  前向型指针 窗口类                www.lintcode.com/problem/longest-substring-without-repeating-characters  
OK * M  前向型指针 窗口类                www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters  
OK   M  两个数组两个指针                 www.lintcode.com/problem/the-smallest-difference 求两个数组A和B中任意两个元素的最小差值  
OK   H  ????                             www.lintcode.com/problem/sliding-window-matrix-maximum 先求出sum[i][j]表示[i][j]位置的矩形和, 再利用sum数组遍历求k矩形最大值  
O ===H================================== www.lintcode.com/problem/subarray-sum-ii ========================================== Follow Up  
O    M                                   www.lintcode.com/problem/submatrix-sum  
O    M                                   www.lintcode.com/problem/continuous-subarray-sum  
O    M                                   www.lintcode.com/problem/continuous-subarray-sum-ii  
O    M                                   www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix  
O    H                                   www.lintcode.com/problem/find-peak-element-ii  
O    H                                   www.lintcode.com/problem/maximum-gap  
O    E                                   www.lintcode.com/problem/build-post-office  
O    M                                   www.lintcode.com/problem/build-post-office-ii  
O    E                                   www.lintcode.com/problem/nested-list-weight-sum  
O    M                                   www.lintcode.com/problem/bomb-enemy  
O    M                                   www.lintcode.com/problem/zigzag-iterator  
O    M                                   www.lintcode.com/problem/zigzag-iterator-ii  
O ===E================================== www.lintcode.com/problem/climbing-stairs-ii ==================================== Selected Problems in Past Exam  
O    M                                   www.lintcode.com/problem/lowest-common-ancestor-iii  
O    M                                   www.lintcode.com/problem/find-the-missing-number-ii  
O    M                                   www.lintcode.com/problem/number-of-ways-to-represent-n-cents  
O ===E================================== www.lintcode.com/problem/kth-largest-in-n-arrays =============================== Follow Up  
O    M                                   www.lintcode.com/problem/segment-tree-build  
O    M                                   www.lintcode.com/problem/segment-tree-build-ii  
O    M                                   www.lintcode.com/problem/segment-tree-modify  
O    M                                   www.lintcode.com/problem/segment-tree-query  
O    M                                   www.lintcode.com/problem/interval-minimum-number  
OK===E  两层for搞定,注意for的范围        www.lintcode.com/problem/strstr ======================================================= Coding Style  
OK===M  字符串操作                       www.lintcode.com/problem/roman-to-integer ============================================= Amazon
OK   M  Greedy                           www.lintcode.com/problem/gas-station
OK   M                                   www.leetcode.com/problems/product-of-array-except-self
