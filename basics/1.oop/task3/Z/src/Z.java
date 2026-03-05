public class Z {
    void solve(int k, int s) {
        int c = 0;
        for (int i = 0; i <= k; i++) {
            for (int g = 0; g <= k; g++) {
                if (s - g - i <= k && s - g - i >= 0)
                    c++;
            }
        }
        System.out.println(c);
    }
}
