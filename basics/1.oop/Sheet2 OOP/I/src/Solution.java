public class Solution {
    long n;

    public Solution(long n) {
        this.n = n;
    }

    public void solve() {
        long rev = 0;
        long m = n;
        while (n != 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        if (m == rev) {
            System.out.println(rev);
            System.out.print("YES");
        } else {
            System.out.println(rev);
            System.out.print("NO");
        }
    }
}