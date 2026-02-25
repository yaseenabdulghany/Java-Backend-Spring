public class Solution {
    double n, m;

    Solution(double n, double m) {
        this.n = n;
        this.m = m;
    }

    public void floor() {
        System.out.println("floor " + n + " " + "/ " + m + " = " + Math.floor(n / m));
    }
    public void ceil() {
        System.out.println("ceil " + n + " " + "/ " + m + " = " + Math.ceil(n / m));
    }
    public void round(){
        System.out.println("round " + n + " " + "/ " + m + " = " + Math.round(n / m));
    }
}
