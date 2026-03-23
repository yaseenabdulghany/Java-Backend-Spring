public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        int flag = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.println("NO");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.print("YES");
        }
    }
}