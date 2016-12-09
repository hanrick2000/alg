//定理：gcd(a,b) = gcd(b,a mod b)

int gcd(int a, int b) {
    if (b == 0) {
        return Math.abs(a);
    }
    return gcd(b, a % b);
}

int gcd(int a, int b){
    while(b != 0){
        int tmp = b;
        b = a % b;
        a = tmp;
    }
    return a;
}
