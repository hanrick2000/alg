/*
75分钟，只有一道题，输入一个字符串表示employee信息，用"--"分割每个employee信息，例如
Fred,Karl,Technician,2010--Karl,Cathy,VP,2009--Cathy,NULL,CEO,2007
所以拆开来有三个employee的数据，其中每个数据都是一个四元组，用","分开，分别是name, managere, title, year
Fred,Karl,Technician,2010 (表示employee name是Fred，他的manager是Karl，他的title是Technician，2010入职)
Karl,Cathy,VP,2009 
Cathy,NULL,CEO,2007 (NULL说明这个是大boss了，他头上没有别人了)

要求输出公司的结构表，如下
Case #1
Cathy (CEO) 2007
-Karl (VP) 2009
--Fred (Technician) 2010
"-"表示对应的level

解法：处理数据比较麻烦，处理完数据用hashmap之类的建一个graph，用dfs跑一下整个graph就得出结果


给你一棵树，树的节点如下
class Node {
  name: “name of a person”
  manages: [] //array of Nodes
}
然后告诉你三个特殊字符：┣ ┗ ┃ ,打印出这种东西。当然空格也可以用

Ming
┣ Alex
┃┗ Paul
┗ Lisa
*/
