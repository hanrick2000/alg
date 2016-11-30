import java.util.List;
import java.util.ArrayList;
/*
bcd
bdc
cbd
cdb
dbc
dcb

m=4, char=a
m=3, char=b
m=2, char=c
m=1, char=d
abcd
m=4, char=a
m=3, char=c

abcd list='' m=0
2/6=0 list=a bcd 2%6=2
2/2=1 list=
*/

class GetK{
    public String getK(int k){
        List<Character> chars = new ArrayList<Character>();
        for(Character i = 'a'; i <= 'd'; i++){
            chars.add(i);
        }
        StringBuilder list = new StringBuilder();
        return helper(list, k, chars);
    }
    private String helper(StringBuilder list, int k, List<Character> chars){
        //list是当前选取了的list
        //k是从剩余的chars中取第k个字典序
        //chars是剩余的集合
        //目标长度
        int m = chars.size();
        if(m > 3){
            System.out.println("m="+m+", char="+chars.get(k/factorial(m-1))+", k/(m-1)!="+(k/factorial(m-1)));
            list.append(chars.get(k / factorial(m - 1)));
            chars.remove(k / factorial(m - 1));
            return helper(list, k % factorial(m - 1), chars);
        }else if(m == 3){
            System.out.println("m="+m+", char="+chars.get(k-1));
            list.append(chars.get(k-1));
            chars.remove(k-1);
            return helper(list, 1, chars);
        }else if(m == 2){
            System.out.println("m="+m+", char="+chars.get(k-1));
            list.append(chars.get(k-1));
            chars.remove(k-1);
            return helper(list, 1, chars);
        }else if(m == 1){
            System.out.println("m="+m+", char="+chars.get(0));
            list.append(chars.get(0));
            chars.remove(0);
            return list;
        }
        return null;
    }
    private int factorial(int k){
        int result = 1;
        for(int i = 1; i <= k; i++){
            result *= i;
        }
        return result;
    }
    public static void main(String args[]){
        GetK test = new GetK();
        System.out.println(test.getK(1));
        System.out.println(test.getK(2));
    }
}
