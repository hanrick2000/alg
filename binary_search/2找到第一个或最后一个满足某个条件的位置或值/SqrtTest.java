class SqrtTest{
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
    public static void main(String[] args){
        System.out.println(sqrt(10));
        System.out.println(sqrt(4));
        System.out.println(sqrt(9));
        System.out.println(sqrt(100));
        System.out.println(sqrt(99));
    }
}
