public class Solution {
    int a, b;

    public Solution(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void solve() {
        int maxs = 0;
        for (int i = 1; i <= 1000; i++) {
            if (a % i == 0 && b % i == 0) {
                if (i > maxs) {
                    maxs = i;
                }
            }
        }
        System.out.print(maxs);
    }
}