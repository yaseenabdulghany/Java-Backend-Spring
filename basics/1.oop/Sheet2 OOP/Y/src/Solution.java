public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        int a = 0, b = 1;
        if (n == 0 || n == 1) {
            System.out.print(a);
        } else {
            System.out.print(a + " " + b + " ");
            for (int i = 2; i < n; i++) {
                int c = a + b;
                System.out.print(c + " ");
                a = b;
                b = c;
            }
        }
    }
}