public class Solution {
    int n;
    String[] s;

    public Solution(int n, String[] s) {
        this.n = n;
        this.s = s;
    }

    public void solve() {
        for (int i = 0; i < n; i++) {
            String t = s[i];
            int sz = t.length();
            for (int j = sz - 1; j >= 0; j--) {
                System.out.print(t.charAt(j) + " ");
            }
            System.out.println();
        }
    }
}