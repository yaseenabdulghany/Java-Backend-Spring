public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        for (int i = 2; i <= n; i++) {
            boolean prim = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0 && i != j) {
                    prim = false;
                }
            }
            if (prim) {
                System.out.print(i + " ");
            }
        }
    }
}