/*
Given an array of integers, 
how many three numbers can be found in the array, 
so that we can build an triangle whose three edges length is the three numbers that we find?
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]

Given array S = [4,4,4,4], return 4. They are:
[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
*/
public class Solution {
    public int triangleCount(int S[]) {
        int ans = 0;
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++) {
            int left = 0;
            int right = i - 1;
            while(left < right) {
                if(S[left] + S[right] > S[i]) {
                    ans = ans + (right - left);
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return ans;
    }
}

//my version
public class Solution{
  public int triangleCount(int S[]) {
    if(S == null) return 0;
    if(S.length < 2) return 0;
    int ans = 0;
    int n = S.length;
    Arrays.sort(S);
    for(int i=2; i<n; i++){
      int left = 0;
      int right = i - 1;
      while(left<right){
        if(S[left] + S[right] > S[i]){
          ans = ans + (right-left);
          right--;
        }else{
          left++;
        }
      }
    }
    return ans;
  }
}
