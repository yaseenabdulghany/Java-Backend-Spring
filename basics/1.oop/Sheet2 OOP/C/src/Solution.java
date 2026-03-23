public class Solution {
    int x;
    int[] values;

    public Solution(int x, int[] values) {
        this.x = x;
        this.values = values;
    }

    public void solve() {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < x; i++) {
            int v = values[i];
            if (v % 2 == 0) {
                a++;
            } else if (v % 2 != 0) {
                b++;
            }
            if (v > 0) {
                c++;
            } else if (v < 0) {
                d++;
            }
        }
        System.out.println("Even: " + a);
        System.out.println("Odd: " + b);
        System.out.println("Positive: " + c);
        System.out.println("Negative: " + d);
    }
}