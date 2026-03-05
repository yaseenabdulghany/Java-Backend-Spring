public class I {
    void solve(int n) {
        String s = Integer.toString(n);
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') ans += s.charAt(i);
        }
        System.out.println(ans);
        for (int i = 0; i < ans.length() / 2; i++) {
            if (ans.charAt(i) != ans.charAt(ans.length() - i - 1)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}