public class E {
    int solve(int[] arr) {
        int mx = -1;
        for (int x : arr) mx = Math.max(mx, x);
        return mx;
    }
}