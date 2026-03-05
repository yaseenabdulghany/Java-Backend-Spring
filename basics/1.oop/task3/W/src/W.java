public class W {
    void solve(int n) {
        for (int i = 1; i <= n; i++) {
            for (int x = 0; x < n - i; x++) {
                System.out.print(" ");
            }
            for (int c = 0; c < 2 * i - 1; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i > 0; i--) {
            for (int f = n - i; f > 0; f--) {
                System.out.print(" ");
            }
            for (int j = 2 * i - 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
