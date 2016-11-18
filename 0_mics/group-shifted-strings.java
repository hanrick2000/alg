public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') { //为了应对这种: ["az", "ba"], 当遇到"ba"时, offset是1, 向左移动1后, b变成a, a变成了不是字母的,就要加上26让它回到'a'到'z'的范围
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            //Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}

/*
az
offset=0
key=az az->az
ba
offset=1
key=a
*/

/*
Input:
["abc","bcd","acef","xyz","az","ba","a","z"]
Output:
[["a","z"],["abc","bcd","xyz"],["az"],["acef"],["ba"]]
Expected:
[["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
*/

/*
Given a string, we can "shift" each of its letter to its successive letter, 
for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, 
group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Company Tags Google Uber
Tags Hash Table String
Similar Problems (M) Group Anagrams
*/

