public class Solution {
    int n;

    public Solution(int n) {
        this.n = n;
    }

    public void solve() {
        for (int row = n; row > 0; row--) {
            for (int column = 0; column < row; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}