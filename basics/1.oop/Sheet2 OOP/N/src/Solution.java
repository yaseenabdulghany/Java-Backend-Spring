public class Solution {
    char S;
    int n;
    int[] arr;

    public Solution(char S, int n, int[] arr) {
        this.S = S;
        this.n = n;
        this.arr = arr;
    }

    public void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print(S);
            }
            System.out.println();
        }
    }
}