// version 1: O(n) scan
class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        // p2, p3 & p5 share the same queue: uglys
        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;
            uglys.add(Math.min(Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3), uglys.get(p5) * 5));
        }
        return uglys.get(n - 1);
    }
}

// version 2 O(nlogn) HashMap + Heap
class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for (int i = 0; i < 3; i++) {
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = Q.poll();
            for (int j = 0; j < 3; j++) {
                if (!inQ.contains(primes[j] * number)) {
                    Q.add(number * primes[j]);
                    inQ.add(number * primes[j]);
                }
            }
        }
        return number.intValue();
    }
}

/*
Ugly number is a number that only have factors 2, 3 and 5.
Design an algorithm to find the nth ugly number. 
The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
1  2^0*3^0*5^0 
2  2^1*3^0*5^0 
3  2^0*3^1*5^0 
4  2^2*3^0*5^0 
5  2^0*3^0*5^1 
6  2^1*3^1*5^0 
8  2^3*3^0*5^0 
9  2^0*3^2*5^0 
10 2^1*3^0*5^1 
12 2^2*3^1*5^0 

Notice: Note that 1 is typically treated as an ugly number.
Example
If n = 9, return 10.
Challenge 
O(n log n) or O(n) time.
Tags: Priority Queue
*/
