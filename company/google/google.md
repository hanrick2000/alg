一个typo:
题目是给一个字典，里面全是string，字典很大，可能有几百万个string。
然后写一个方法判断输入是否有一个typo，否则返回false。
比如，字典有google，facebook，amazon等。
输入google返回false，因为没有typo。
输入geogle，返回true，因为有一个typo。
输入geogla，返回false，因为有多于一个的typo。

方法非常简单，在处理的时候，把google的每个字符逐个去掉一次，然后看看剩下的字符串是啥：
google =>
[
  "oogle",
    "gogle",
    "gogle",
    "goole",
    "googe",
    "googl"
]
所以把N* L 个 字符串放到hash表里。
接着你要查询geogle的时候，也逐个去掉每个字符，然后看一下去掉之后的字符串是否在预处理过的hash表中，就好了。因此你会发现geogle去掉e之后的，gogle是在hash里的，于是return true。

=====

Google我推荐大家都去试一试，因为他家确实不管背景强弱，都会给机会。电面题比较基础，medium不到的难度。楼主怀着朝圣的心（学渣就是这么肤浅）屁颠屁颠去onsite了。

====

Google的面试题比较活，follow-up比较多，可能比较背，所有题目都没做过，也没命中面经。非常喜欢Google的面试方式，感觉是在和面试官一起讨论一个问题而不是被问好多奇怪的知识点

====


