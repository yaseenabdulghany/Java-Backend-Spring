public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
}