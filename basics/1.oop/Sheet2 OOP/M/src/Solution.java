public class Solution {
    int a, b;

    public Solution(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void solve() {
        int count = 0;
        for (int n = a; n <= b; n++) {
            int m = n;
            boolean luk = true;
            while (m != 0) {
                if (m % 10 != 4 && m % 10 != 7)
                    luk = false;
                m /= 10;
            }
            if (luk == true) {
                System.out.print(n + " ");
                count++;
            }
        }
        if (count == 0) {
            System.out.print("-1");
        }
    }
}