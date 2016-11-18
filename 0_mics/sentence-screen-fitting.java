public int wordsTyping(String[] sentence, int rows, int cols) {
    int[] nextIndex = new int[sentence.length];
    int[] times = new int[sentence.length];
    for(int i = 0; i < sentence.length; i++) {
        int curLen = 0;
        int cur = i;
        int time = 0;
        while(curLen + sentence[cur].length() <= cols) {
            curLen += sentence[cur++].length() + 1;
            if(cur == sentence.length) {
                cur = 0;
                time ++;
            }
        }
        nextIndex[i] = cur;
        times[i] = time;
    }
    int ans = 0;
    int cur = 0;
    for(int i = 0; i < rows; i++) {
        ans += times[cur];
        cur = nextIndex[cur];
    }
    return ans;
}

/*
First off, we can easily come up with a brute-force solution. 
The basic idea of optimized solution is that
sub-problem: if there's a new line which is starting with certain index in sentence, what is the starting index of next line (nextIndex[]). BTW, we compute how many times the pointer in current line passes over the last index (times[]).
relation : ans += times[i], i = nextIndex[i], for _ in 0..<row. where i indicates what is the first word in the current line.
Time complexity : O(n*(cols/lenAverage)) + O(rows), where n is the length of sentence array, lenAverage is the average length of the words in the input array.

Well, It's not a typical "DP" problem and I am not even sure it is a "DP" problem.
*/


//DP
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] dp = new int[sentence.length];
        int n = sentence.length;
        for(int i = 0, prev = 0, len = 0; i < sentence.length; ++i) {
            // remove the length of previous word and space
            if(i != 0 && len > 0){ 
                len -= sentence[i - 1].length() + 1;
            }
            // calculate the start of next line.
            // it's OK the index is beyond the length of array so that 
            // we can use it to count how many words one row has.
            while(len + sentence[prev % n].length() <= cols) {
                len += sentence[prev++ % n].length() + 1;
            }
            dp[i] = prev;
        }
        int count = 0;
        for(int i = 0, k = 0; i < rows; ++i) {
            // count how many words one row has and move to start of next row.
            // It's better to check if d[k] == k but I find there is no test case on it. 
            // if(dp[k] == k) return 0;
            count += dp[k] - k;
            k = dp[k] % n;
        }
        // divide by the number of words in sentence
        return count / n;
    }
}

/*
It's kind of like a jump game. I use a array to record for each word, how far it can jump.
eg. dp[index] means if the row start at index then the start of next row is dp[index].
dp[index] can be larger than the length of the sentence, in this case, one row can span multiple sentences.
I comment the check whether a word is longer than the row since there is no such test case. But it's better to check it. And it make little difference to the speed.
*/

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0;
        int l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++; //调整下一行的开头
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }
        return start / l;
    }
}
/*
Say sentence=["abc", "de", "f], rows=4, and cols=6.
The screen should look like
"abc de"
"f abc "
"de f  "
"abc de"
Consider the following repeating sentence string, 
with positions of the start character of each row on the screen.
"abc de f abc de f abc de f ..."
 ^      ^     ^    ^      ^
 0      7     13   18     25
Our goal is to find the start position of the row next to the last row on the screen, 
which is 25 here. 
Since actually it's the length of everything earlier, 
we can get the answer by dividing this number by the length of (non-repeated) sentence string. 
Note that the non-repeated sentence string has a space at the end; it is "abc de f " in this example.
Here is how we find that position. 
In each iteration, we need to adjust start based on spaces either added or removed.
"abc de f abc de f abc de f ..." // start=0
 012345                          // start=start+cols+adjustment=0+6+1=7 (1 space removed in screen string)
        012345                   // start=7+6+0=13
              012345             // start=13+6-1=18 (1 space added)
                   012345        // start=18+6+1=25 (1 space added)
Hope this helps.
*/


/*
Given a [rows x cols] screen and a sentence represented by a list of words, 
find how many times the given sentence can be fitted on the screen.

Note:
1 A word cannot be split into two lines.
2 The order of words in the sentence must remain unchanged.
3 Two consecutive words in a line must be separated by a single space.
4 Total words in the sentence won't exceed 100.
5 Length of each word won't exceed 10.
6 1 ≤ rows, cols ≤ 20,000.

Example 1:
Input:
rows = 2, cols = 8, sentence = ["hello", "world"]
Output: 
1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.

Example 2:
Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
Output: 
2
Explanation:
a-bcd- 
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.

Example 3:
Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
Output: 
1
Explanation:
I-had
apple
pie-I
had--
The character '-' signifies an empty space on the screen.

Company Tags Google
Tags Dynamic Programming
*/
