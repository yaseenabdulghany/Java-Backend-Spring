public class Solution {
    long x;
    long[] values;

    public Solution(long x, long[] values) {
        this.x = x;
        this.values = values;
    }

    public void solve() {
        long ans = 1;
        for (int i = 0; i < x; i++) {
            long y = values[i];
            for (int j = 1; j <= y; j++) {
                ans *= j;
            }
            System.out.println(ans);
            ans = 1;
        }
    }
}