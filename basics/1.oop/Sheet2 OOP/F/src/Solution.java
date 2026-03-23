public class Solution {
    int x;

    public Solution(int x) {
        this.x = x;
    }

    public void solve() {
        for (int i = 1; i <= 12; i++) {
            System.out.println(x + " * " + i + " = " + x * i);
        }
    }
}