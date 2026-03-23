public class Solution {
    long n, a, b;

    public Solution(long n, long a, long b) {
        this.n = n;
        this.a = a;
        this.b = b;
    }

    public void solve() {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            long sd = 0;
            while (x != 0) {
                int m = x % 10;
                sd += m;
                x /= 10;
            }
            if (sd >= a && sd <= b) {
                sum += i;
            }
        }
        System.out.print(sum);
    }
}