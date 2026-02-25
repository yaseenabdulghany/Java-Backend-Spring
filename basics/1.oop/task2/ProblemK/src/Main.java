import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        Solution sol = new Solution();
        System.out.print(sol.min(n,m,k)+" ");
        System.out.println(sol.max(n,m,k));
    }
}