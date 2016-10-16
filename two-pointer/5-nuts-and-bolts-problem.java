/*
Given a set of n nuts of different sizes and n bolts of different sizes. 
There is a one-one mapping between nuts and bolts. 
Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
We will give you a compare function to compare nut with bolt.

Have you met this question in a real interview? Yes
Example
Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

Your code should find the matching bolts and nuts.
one of the possible return:
nuts  = ['ab','bc','dd','gg'], 
bolts = ['AB','BC','DD','GG'].
we will tell you the match compare function. If we give you another compare function.
the possible return is the following:
nuts  = ['ab','bc','dd','gg'], 
bolts = ['BC','AA','DD','GG'].
So you must use the compare function that we give to do the sorting.
The order of the nuts or bolts does not matter. 
You just need to find the matching bolt for each nut.
*/
/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null) return;
        if (nuts.length != bolts.length) return;
        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    private void qsort(String[] nuts, String[] bolts, NBComparator compare, 
                       int l, int u) {
        if (l >= u) return;
        // find the partition index for nuts with bolts[l]
        int part_inx = partition(nuts, bolts[l], compare, l, u);
        // partition bolts with nuts[part_inx]
        partition(bolts, nuts[part_inx], compare, l, u);
        // qsort recursively
        qsort(nuts, bolts, compare, l, part_inx - 1);
        qsort(nuts, bolts, compare, part_inx + 1, u);
    }
    private int partition(String[] str, String pivot, NBComparator compare, 
                          int l, int u) {
        for (int i = l; i <= u; i++) {
            if (compare.cmp(str[i], pivot) == 0 ||  //pivot is bolt
                compare.cmp(pivot, str[i]) == 0) {  //pivot is nut
                swap(str, i, l);
                break;
            }
        }
        String now = str[l];
        int left = l; 
        int right = u;
        while (left < right) { //按照pivot划分, 左边的是大的, 右边的是小的
            // 先从右向左看
            while (left < right && 
            (compare.cmp(str[right], pivot) == -1 ||  //pivot is bolt, pivot>str[right]
             compare.cmp(pivot, str[right]) == 1)) {  //pivot is nut
                //如果pivot>str[right] 直到找到一个str[right]大于等于pivot, 然后把这个str[right]放到str[left]上去
                right--;
            }
            str[left] = str[right];
            // 再从左向右看
            while (left < right && 
            (compare.cmp(str[left], pivot) == 1 ||  //pivot is bolt, pivot<str[left]
            compare.cmp(pivot, str[left]) == -1)) { //pivot is nut
                // 如果pivot<str[left] 直到找到一个str[left]小于等于pivot, 然后把这个str[left]放到str[right]上去
                left++;
            }
            str[right] = str[left];
        }
        str[left] = now;
        return left;
    }
    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
}





// first my version
public class Solution{
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare){
        if(nuts == null || bolts == null) return;
        if(nuts.length != bolts.length) return;
        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    public void qsort(String[] nuts, String[] bolts, NBComparator compare, int l, int r){
        if(l >= r) return;
        int idx = partitions(nuts, bolts[l], compare, l, r);
        partitions(bolts, nuts[idx], compare, l, r);
        qsort(nuts, bolts, compare, l, idx - 1);
        qsort(nuts, bolts, compare, idx + 1, r);
    }
    public int partitions(String[] str, String pivot, NBComparator compare, int l, int r){
        for(int i=l; i <= r; i++){
            if(compare.cmp(str[i], pivot) == 0 ||
               compare.cmp(pivot, str[i]) == 0){
               swap(str, i, l);
            }
        }
        int left = l;
        int right = r;
        String now = str[l];
        while(left < right){
            //找到第一个right, 使得str[right]>pivot
            while(left < right && (compare.cmp(str[right], pivot) == -1 || //pivot is bolt
                                   compare.cmp(pivot, str[right]) == 1)){
                right--;
            }
            str[left] = str[right];
            //找到第一个left, 使得str[left]<pivot
            while(left < right && (compare.cmp(str[left], pivot) == 1 || //pivot is bolt
                                   compare.cmp(pivot, str[left]) == -1)){
                left++;
            }
            str[right] = str[left];
        }
        str[left] = now;
        return left;
    }
    public void swap(String[] str, int a, int b){
        String tmp = str[a];
        str[a] = str[b];
        str[b] = tmp;
    }
}


/* 模拟过程
0 1 2 3 4 5
8 2 9 1 3 4  p=3 l=0 r=5       把pivot 3跟left换位置, 并用now记录pivot的值
3 2 9 1 8 4  p=3 l=0 r=5 now=3 从右向做遍历, 找到4大于pivot, 把4放到left位置, 这时l=0, r=5
4 2 9 1 8 4  p=3 l=0 r=5 now=3 从左向右遍历, 找到2小于pivot, 把2放到right位置, 这时l=1, r=5
4 2 9 1 8 2  p=3 l=1 r=5 now=3 从右向左遍历, 找到8大于pivot, 把8放到left位置, 这时l=1, r=4
4 8 9 1 8 2  p=3 l=1 r=4 now=3 从左向右遍历, 找到1小于pivot, 把1放到righ位置, 这时l=3, r=4
4 8 9 1 1 2  p=3 l=3 r=4 now=3 r--后r<=l 退出
4 8 9 3 1 2  p=3 l=3 r=3 now=3
*/
