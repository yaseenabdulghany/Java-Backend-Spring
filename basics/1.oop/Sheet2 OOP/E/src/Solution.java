public class Solution {
    int x;
    long[] values;

    public Solution(int x, long[] values) {
        this.x = x;
        this.values = values;
    }

    public void solve() {
        int z = 0;
        for (int i = 0; i < x; i++) {
            long v = values[i];
            if (v > z) {
                z = (int) v;
            }
        }
        System.out.print(z);
    }
}