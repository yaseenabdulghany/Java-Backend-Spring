public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        for (int i = 2; i <= n; i += 2)
            System.out.println(i);
        if (n < 2) {
            System.out.println("-1");
        }
    }
}