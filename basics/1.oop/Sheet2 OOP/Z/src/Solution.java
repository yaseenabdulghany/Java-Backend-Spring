public class Solution {
    int k, s;

    public Solution(int k, int s) {
        this.k = k;
        this.s = s;
    }

    public void solve() {
        int count = 0;
        for (int x = 0; x <= k; x++) {
            for (int y = 0; y <= k; y++) {
                int z = s - (x + y);
                if (z >= 0 && z <= k) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}