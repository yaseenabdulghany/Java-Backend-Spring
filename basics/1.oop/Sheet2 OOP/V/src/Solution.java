public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        int x = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = x; j <= x + 2; j++) {
                System.out.print(j + " ");
            }
            System.out.println("PUM");
            x += 4;
        }
    }
}