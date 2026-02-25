public class Solution {
    String s1, f1, s2, f2;

    public Solution(String s1, String f1, String s2, String f2) {
        this.s1 = s1;
        this.s2 = s2;
        this.f1 = f1;
        this.f2 = f2;
    }

    public String solve() {
        return (f1.equals(f2)) ? "ARE Brothers" : "NOT";
    }
}