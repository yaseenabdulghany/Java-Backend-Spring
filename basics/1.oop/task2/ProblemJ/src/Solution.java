public class Solution {
    public String solve(int n, int m) {
        if (n % m == 0 || m % n == 0) return "Multiples";
        return "No Multiples";
    }
}