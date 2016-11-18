public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<String>();
        // 初始化prev为lower-1，判断是否存在“第一个”区间
        int prev = lower - 1;
        int curr = 0;
        for(int i = 0 ; i <= nums.length; i++){ //多判断两次, 为了数组头与lower, 和数组尾与upper
            // 当遍历到length时，设置curr为upper+1，判断是否存在“最后一个”区间
            if(i == nums.length){
                curr = upper + 1;
            }else{
                curr = nums[i];
            }
            // 如果上一个数和当前数相差大于1，说明之间有区间
            if(curr - prev > 1){
                res.add(getRanges(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return res;
    }
    private String getRanges(int from, int to){
        String result = null;
        if(from == to){
            result = String.valueOf(from);
        }else{
            result = "" + from + "->" + to;
        }
        return result;
    }
}
/*
我们用一个指针prev记录上次range的结尾，一个指针curr记录当前遍历到的数字，如果curr和prev相差大于1，说明一个missing range，我们将其加入结果列表中就行了。这题主要是有几个corner case要解决：
如何处理lower到第一个数，和最后一个数到upper的missing range？
如何区分range中只有一个数和多个数？
如何有效的得到missing range的起始和结束值，同时保证不会包含数组中的数字？
对于第一个问题，我们要做的就是在让for循环多判断两次。想象一下假设数组前有一段连续的负无穷到lower-1，数组后有一段upper+1到正无穷，这样是等价与上下界的。本来如果不考虑头尾，那for循环本应是从1到length-1的，但是为了判断头，我们从0开始，将下标为0的数和lower-1比较得到第一个range。最后循环到length停止，当下标为length时，我们将当前指针指向upper+1，并判断upper+1和数组末尾是否能构成最后一个区间。
对于第二个问题，我们只要判断这个区间的起止是否一样就行了
对于第三个问题，我们用prev+1和curr-1来标记这个区间的起止，因为prev和curr都是数组中的数，所以解决了每个区间的边界问题
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], 
return its missing ranges.
For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
return ["2", "4->49", "51->74", "76->99"].
Company Tags Google
Tags Array
Similar Problems (M) Summary Ranges
*/
