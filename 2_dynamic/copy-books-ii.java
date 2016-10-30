public class Solution {
    public int copyBooksII(int n, int[] times) {
        int k = times.length;
        int[][] f = new int[k][n + 1]; //f[i][j]表示i个人分配给前j本书的最小cost
        for (int j = 0 ; j <= n; ++j) { //第1个人, copy 前j本书需要的时间
            f[0][j] = j * times[0];
        }
        for (int i = 1; i < k; ++i) { //人数
            for (int j = 1; j <= n; ++j) { // 前j本书
                f[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= j; ++l) { //枚举新加进来的人i, 处理多少本书
                    f[i][j] = Math.min(f[i][j], Math.max(f[i - 1][j - l], times[i] * l));
                    if (f[i - 1][j - l] <= times[i] * l) {
                        break;
                    }
                }
            }
        }
        return f[k - 1][n];
    }
}

//带rolling array
public class Solution {
    public int copyBooksII(int n, int[] times) {
        int k = times.length;
        int[][] f = new int[2][n+1];
        for (int j = 0 ; j <= n; ++j) {
            f[0][j] = j * times[0];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i%2][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= j; ++l) {
                    f[i%2][j] = Math.min(f[i%2][j], Math.max(f[(i-1)%2][j-l], times[i] * l));
                    if (f[(i-1)%2][j-l] <= times[i] * l) {
                        break;
                    }
                }

            }
        }
        return f[(k-1)%2][n];
    }
}

Given n books( the page number of each book is the same) 
and an array of integer with size k means k people to copy the book 
and the i th integer is the time i th person to copy one book. 
You must distribute the continuous id books to one people to copy. 
(You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.) 
Return the number of smallest minutes need to copy all the books.

Example
Given n = 4, array A = [3,2,4]
有4本书, 3个人, 每个人copy一本书的时间分别是3,2,4

Return 4( 
  First person spends 3 minutes to copy book 1, 
  Second person spends 4 minutes to copy book 2 and 3, 
  Third person spends 4 minutes to copy book 4. )
