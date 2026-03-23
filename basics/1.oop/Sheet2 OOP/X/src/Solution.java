public class Solution {
    int n;
    long[] v;

    public Solution(int n, long[] values) {
        this.n = n;
        this.v = values;
    }

    public void solve() {
        for (int i = 0; i < n; i++) {
            long t = v[i];
            int p = 0;
            long sum = 0;
            while (t != 0) {
                int y = (int)(t % 2);
                t /= 2;
                if (y == 1) {
                    sum += (long)Math.pow(2, p);
                    p++;
                }
            }
            System.out.println(sum);
        }
    }
}