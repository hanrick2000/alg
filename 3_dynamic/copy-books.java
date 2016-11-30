public class Solution {
    public int copyBooks(int[] pages, int k) {
        if(pages == null || pages.length == 0){
            return 0;
        }
        if(k < 1){
            return -1;
        }
        int n = pages.length;
        // state
        int[][] f = new int[n + 1][k + 1]; //f[i][j]表示前i本书分配给j个人的最小cost
        // init
        for(int j = 1; j <= k; j++){
            f[1][j] = pages[0];
        }
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += pages[i - 1];
            f[i][1] = sum;
        }
        // function
        for(int i = 2; i <= n; i++){ //前i本书
            for(int j = 2; j <= k; j++){ //前j个人
                if(j > i){ 
                    f[i][j] = f[i][j - 1];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int h = 1; h <= i; h++){
                    int temp = Math.max(f[h][j - 1], f[i][1] - f[h][1]); //把前i本书划分成前h本给j-1个人, i-h本给新增的人, 枚举各个划分情况下需要的分钟数
                    min = Math.min(min, temp); 
                }
                f[i][j] = min;
            }
        }
        return f[n][k];
    }
}

/*
建立一个二维数组(n+1 * k+1)，f[i][j]表示前i本书分配给j个人copy。
初始化f[1][j]=pages[0]，初始化f[i][1]= pages[0] + pages[1] + ... + pages[i-1]
然后从2本书开始到n本书为止，依次计算分配给2～k个人的最小时间。当人数比书大时，有些人不干活也不会影响速度，因此和少一个人情况相同。
对于新加进来的人j，考虑让前j－1个人copy的书的数量h（0～n），则新进来的人相应的copy的数量为n～0本，前者的时间为f[h][j-1]，后者的时间为f[i][1]-f[h][1]（即一个人copy从h＋1到i本需要的时间），两者的较大值即为f[i][j]的一个后选项。选择所有后选项中的最小值即为f[i][j]的值。这里可以优化，即我们知道如果前j－1个人copy的书的数量少于j－1必然有人不干活，而所有人都干活的结果一定会更快，所以h的范围可以从j－1～n，因为我们知道h为0～j－1时的结果一定不会是最优的答案。

Given an array A of integer with size of n(means n books and number of pages of each book) 
and k people to copy the book. You must distribute the continuous id books to one people to copy. 
(You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.) 
Each person have can copy one page per minute. Return the number of smallest minutes need to copy all the books.
Example
Given array A = [3,2,4], k = 2.
Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
Challenge 
Could you do this in O(n*k) time ?
*/
