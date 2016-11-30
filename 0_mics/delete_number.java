public class delete_number{  
    public static String doDelete(String n, int s){  
        char[] numberArray = n.toCharArray();  
        int len = numberArray.length; //标记当前剩余的数的长度 
        if(len <= s) {  
            System.out.println("invalid s!");  
            return null;  
        }  
        int deleteLength = 0; //标记已经删了几个数 
        int pos = 1;  
        while(pos < len){  
            if(numberArray[pos] < numberArray[pos - 1]) {//如果当前数小于前一个数, 删掉前一个数  
                int i = pos;  
                while(i < len){  
                    numberArray[i - 1] = numberArray[i];  
                    ++i;  
                }  
                pos = pos > 1 ? --pos : pos;  
                --len;  
                ++deleteLength;  
            }else{  
                pos++;  
            }  
            if(deleteLength == s){ 
                break;  
            }
        }
        len = len - (s - deleteLength);  

        StringBuilder sb = new StringBuilder();  
        for(int index = 0; index < len; ++index){  
            sb.append(numberArray[index]);  
        }  
        return sb.toString();  
    }  
    public static void main(String[] args) {  
        String n = "178543";  
        int s = 4;  
        String result = delete_number.doDelete(n,s);
        System.out.println(result);
    }  
}  
/*
键盘输入一个高精度的正整数n(<=240位),
去掉任意s个数字后剩下的数字按原左右次序将组成一个新的正整数.
编程对给定的n和s,寻找一种方案,使得剩下的数最小.
Simple Input
178543
4
Simple Output
13
思路:
每一步总是选择一个使剩下的数最小的数字删除,
即按高位到低位的顺序搜索,若各位数字递增,则删除最后一个数字;
否则删除第一个递减区间的首字符,
这样删一位便形成了一个新的数字串.
然后回到串首,按上述规则再删除下一个数字

178543
78543
18543
17543 -
17843
17853
17854

17543
7543
1543
1743
1753
1754

412785
12785
42785
41785
41285
41275
41278

*/
