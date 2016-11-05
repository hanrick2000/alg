public class Solution {
    public void sortLetters(char[] chars) {
        if(chars == null || chars.length == 0){
            return;
        }
        int left = 0;
        int right = chars.length - 1;
        char pivot = chars[left];
        while(left < right){
            while(left < right && Character.isUpperCase(chars[right])){
                right--;
            }
            chars[left] = chars[right];
            while(left < right && Character.isLowerCase(chars[left])){
                left++;
            }
            chars[right] = chars[left];
        }
        chars[left] = pivot;
    }
}

Given a string which contains only letters. 
Sort it by lower case first and upper case second.
It's NOT necessary to keep the original order of lower-case letters and upper case letters.
Example
For "abAcD", a reasonable answer is "acbAD"
Challenge 
Do it in one-pass and in-place.
