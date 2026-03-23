public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        int e = 0;
        for (int row = 0; row < n; row++) {
            for (int j = n - 1; j > row; j--) {
                System.out.print(" ");
            }
            for (int st = 0; st <= e; st++) {
                System.out.print("*");
            }
            System.out.println();
            e += 2;
        }
    }
}