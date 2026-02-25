import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 , f1 , s2 , f2 ;
        s1 = input.next();
        f1 = input.next();
        s2 = input.next();
        f2 = input.next();
        Solution sol = new Solution(s1, f1, s2, f2);
        System.out.println(sol.solve());
    }
}