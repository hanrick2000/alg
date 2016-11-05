class Solution {
    public int sqrt(int x) {
        long start = 1;
        long end = x; //x的一个上界
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) { //剩下两个值, 找最接近x里面最大的
            return (int) end;
        } else{
            return (int) start;
        }
    }
}

//follow up: what if return a double, not an integer?
class Solution{
    public static double sqrt(int x){
        double start = 0;
        double end = x;
        double mid = start + (end - start) / 2;
        while((Math.abs(mid * mid - x)) > 0.000001) {
            mid = start + (end - start) / 2;
            if(mid * mid > x){
                end = mid;    
            } else {
                start = mid;
            }
        }
        return mid;
    }
}



Implement int sqrt(int x).
Compute and return the square root of x.
Example
sqrt(3) = 1
sqrt(4) = 2
sqrt(5) = 2
sqrt(10) = 3
Challenge 
O(log(x))
