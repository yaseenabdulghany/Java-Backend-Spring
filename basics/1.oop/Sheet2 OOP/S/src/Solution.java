public class Solution {
    int n;
    int[] xs, ys;

    public Solution(int n, int[] xs, int[] ys) {
        this.n = n;
        this.xs = xs;
        this.ys = ys;
    }

    public void solve() {
        for (int i = 0; i < n; i++) {
            int odd = 0;
            int x = xs[i];
            int y = ys[i];
            for (int j = Math.min(x, y) + 1; j < Math.max(x, y); j++) {
                if (j % 2 != 0) {
                    odd += j;
                }
            }
            System.out.println(odd);
        }
    }
}