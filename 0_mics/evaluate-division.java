public class Solution {
    public double[] calcEquation(String[][] equations, 
                                 double[] values, 
                                 String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) { //建立图的过程
            //add arcs for both directions
            addArc(graph, equations[i][0], equations[i][1], values[i]);
            addArc(graph, equations[i][1], equations[i][0], 1 / values[i]);
        }
        double[] answer = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = getValue(graph, queries[i][0], queries[i][1]);
        }
        return answer;
    }
    public void addArc(Map<String, Map<String, Double>> graph, 
                       String vexStart, 
                       String vexEnd, 
                       double value) {
        Map<String, Double> arcMap;
        if (graph.containsKey(vexStart)) {
            arcMap = graph.get(vexStart);
        } else {
            arcMap = new HashMap<>();
        }
        arcMap.put(vexEnd, value);
        graph.put(vexStart, arcMap);
    }
    public double getValue(Map<String, Map<String, Double>> graph, 
                           String vexStart, 
                           String vexEnd) {
        if (graph.get(vexStart) == null || graph.get(vexEnd) == null) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();   //queue uesd for bfs
        Map<String, Double> value = new HashMap<>(); //(x, v)用于记录从vexStart到当前x的距离v
        Set<String> validation = new HashSet<>();   //validation用于记录当前x是否在queue中了
        //init
        queue.add(vexStart);
        validation.add(vexStart);
        value.put(vexStart, 1d);
        String currentNode, nextNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove(); //从linkedlist头部去掉
            for (Map.Entry<String, Double> arc : graph.get(currentNode).entrySet()) {
                nextNode = arc.getKey();
                value.put(nextNode, value.get(currentNode) * arc.getValue());
                if (nextNode.equals(vexEnd)) {
                    return value.get(vexEnd);
                } else if (!validation.contains(nextNode)) {
                    queue.add(nextNode); //加到linkedlist尾部
                    validation.add(nextNode);
                }
            }
        }
        return -1;
    }
}

现有一些格式为A / B = k的等式，A和B均为字符串变量，k为一个实数（浮点数）。如果能够找到答案，则返回答案。若答案不存在，则返回-1.0。
样例
给出等式a / b = 2.0, b / c = 3.0。
问题为a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?。
返回[6.0, 0.5, -1.0, 1.0, -1.0 ]。
输入为
vector<pair<string, string>> equations, 
vector<double>& values, 
vector<pair<string, string>> queries，
其中equations.size() == values.size()并且values中均为正数。
返回vector<double>。

例如根据上面这个样例，输入的形式就为
equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]
此外，输入永远是有效的，你可以假设所有的除法不会使除数为0，亦不会产生任何冲突。

1. 首先考虑这道题的难点。难点在于题目中要求的解答大多需要动态的计算。
比如题目给出了a / b = 2, b / c = 2，但是题目问的问题却是a / c。
那么我们对此进行一些思考，找到一些计算的思路。
首先，如果两个变量之间有答案，起码它们两个可以被n个等式连起来。
比如我上面举得例子，虽然a和c不能直接被连，但是中间有b作为中间点就可以。
想到这里我们就已经能发现，这个模型已经有点图论的样子了。
起码使用图论能解决连通性的问题（即两变量间能否有答案）。接下来我们再看看能不能用这个图进行计算。

2. 我们将每个除数和被除数都可看做图的顶点，等式的值则可以看成是图的边。
需要注意的是，这个图是一个有向图（因为显然a / b和b / a的值不同，除非a / b = 1），
并且两点间的两条边的值是互为倒数的。
然而输入只给出了一条边，所以在录入时要额外添加作为倒数的边。

3. 这样我们基本已经建立好了图的模型，那么具体的算法是怎样的呢。
我们继续思考发现，这是一个很特殊的图。因为两点间不管走哪条路径，距离都是相同的。
所以对于每个问题，使用广搜从起点搜到终点即可。
如果广搜结束都无法走到终点，显然这两个变量间就是没有答案的。
在搜索时需要注意的一点是，走过的距离不是常见的相加，而是相乘。

4. 参考程序中的图使用了邻接表的存储形式。
如果不用搜索的话，另一种解法是使用邻接矩阵存储，如果想求出任何两个点的最短路径，那么可以用Floyd算法直接算出所有点之间的距离，再依据题目要求返回答案。
