/*
Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.


Hello, I am WangYang, Nice to meet you ^_^
I am already here.


a-z 26!
abc...xyz
zyx...cba
k-th


1 a b c
2 a c b  2!=2
3 b a c
4 b c a
5 c a b
6 c b a


1 a b c d
2 a b d c
3 a c b d
4 a c d b
5 a d b c
6 a d c b  3!=6
7 b a c d
8 b a d c
9 b c a d
10b c d a
11b d a c
12b d c a
 


k = 11, 第11个是一定在b开头的，11-6=5， 问题变换成以[b c d]为可选集按照字典序找第5个。


chars=[a b c d]
a 1-6
b 7-12
c 13-18 
d 18-24


if k = 1 set[]
if k = 2 set[y z]
if k = 3 
1!= 1    a b c d … z []
2!= 2    a b c d … x [y z]
3!= 6    a b c d … w [x y z]
4!= 24
5!= 


list=[abc] set=[]   -1
list=ab    set=[c]
list=a     set=[b c]
list=ac    set=[b]
list=acb   set=[]   -2


list=a     set=[b c]
list=[]    set=[a b c]
list=b     set=[a c]
list=ba    set=[c]
list=bac   set=[]  -3


list=b     set=[a c]
list=bc    set=[a]
list=bca   set=[]  -4




list=[]    set=[a b c]
list=[c]   set=[a b]
list=ca    set=b
list=cab   set=[]


list=cb    


set: 当前可用的字母集合
list: 当前的一个排列（已经排好的）






a b c … x y z
length==26
a b c … x y z     
a b c … x y


private void helper(){
    if(list.size() == 26 && n == k){
        return list;
    }
    for(int i = 0; i < chars.length; i++){
        if(list.contains(chars[i])){
            continue;
        }
        list.add(chars[i]);
        helper(list,chars, k, n);//n当前是第几个排列，k是我要的第k个
        list.remove(list.size() - 1);
    }
}



1  abcd
2  abdc
3  acbd
4  acdb
5  adbc
6  adcb
 
7  bacd
8  badc
9  bcad
10 bcda
11 bdac
12 bdca
  
13 cabd
14 cadb
15 cbad
16 cbda
17 cdab
18 cdba
  
19 dabc
20 dacb
21 dbac
22 dbca
23 dcab
24 dcba

k=15
确定当前第1个字母 15/(3!)=15/6=2, 从可选集合中取第3个字母, 即c, 可选集合剩下[a b d], 剩下15%(3!)=15%6=3, 问题变成了从[a b d]中选取字典序的第3个排列 "c"
确定第2个字母 3/(2!)=3/2=1, 即从可选字符中取第2个字母, 即b, 可选集合剩下[a d], 剩下3%2=1, 问题变成了从[a d]中选取字段序的第1个排列                  "cb"
确定第3个字母 1/(1!)=1, 这时候需要指定了, 当剩下1个时, 就是取可选集合中的第一个, "a"                                                                "cba"
确定第4个字母 只能是d, "cbad"

k: 取当前可选集构成的排列的字典序第k个字符串, m为当前可选集的大小
取第 k/(m-1)! + 1 作为第一个选取的字母, 剩下k%(m-1)!个排列

public String getK(int k){
    List<Character> chars = new ArrayList<Character>();
    for(int i = 0; i < 26; i++){
        chars.append('a'+i);
    }
    String list = "";
    return helper(list, k, chars, 26);
}


private String result helper(String list, int k, List<Character> chars, int n){
    //list是当前选取了的list
    //k是从剩余的chars中取第k个字典序
    //chars是剩余的集合
    //目标长度
    if(list.length() == n){
        return list;
    }
    int m = chars.size()
    if(m > 2){
        list.append(chars.get(k / factorial(m - 1) + 1));
        chars.remove(k / factorial(m - 1) + 1);
        return helper(list, k % factorial(m - 1), chars, n);
    }else if(m == 2){
        list.append(chars.get(k - 1));
        chars.remove(k - 1);
        return helper(list, 1, chars, n);
    }else if(m == 1){
        list.append(chars.get(0));
        chars.remove(0);
        return helper(list, 0, chars, n);
    }
}

*/
