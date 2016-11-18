public int lengthLongestPath(String input) {
    ArrayDeque<Integer> stack = new ArrayDeque<>(); //stack中存的是当前的路径深度
    int result = 0;
    for (String s : input.split("\n")) {
        int level = s.lastIndexOf("\t") + 1; //表示当前处理的是在第几层目录
        while (stack.size() != level) { //确保stack中剩下的层数能够允许当前的s放入
            stack.pop();
        }
        int len = s.substring(level).length();
        if (stack.isEmpty()) {
            stack.push(len);
        } else {
            stack.push(stack.peek() + len + 1); //加1是"/"
        }
        if (s.contains(".")) { //如果是个文件, 就比较下长度是否可以更新
            result = Math.max(result, stack.peek());
        }
    }
    return result;
}

/*
dir
\tsubdir1
\t\tfile1.ext
\t\tsubsubdir1
\tsubdir2
\t\tsubsubdir2
\t\t\tfile2.ext

模拟过程
s=dir level=0 stack.size()=0 stack.size()跟level相等, len=substring(0).length=3, stack=[3]
s=subdir1 level=1 stack.size()=1 len="subdir1"=7, stack=[3,11]
s=file1.ext level=2 stack.size()=2 len="file1.ext"=9, stack=[3,11,21], result=21
s=subsubdir1 level=2 stack.size()=3 stack=[3,11] stack=[3,11,22],result=21
s=subdir2 level=1 stack.size()=3 stack=[3] stack=[3,11], result=22
s=subsubdir2 level=2 stack.size()=2 len="subsubdir2"=10, stack=[3,11,22]
s=file2.ext level=3 stack.size()=3 len="file2.ext"=9, stack=[3,11,22,32], result=32
*/


/*
Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. 
subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. 
subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. 
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", 
and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, 
return the length of the longest absolute path to file in the abstracted file system. 
If there is no file in the system, return 0.

Note:
1 The name of a file contains at least a . and an extension.
2 The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

Company Tags Google
*/

