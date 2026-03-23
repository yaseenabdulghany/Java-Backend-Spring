import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char S;
        S = scanner.next().charAt(0);
        int N;
        N = scanner.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = scanner.nextInt();
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print(S);
            }
            System.out.println();
        }
    }
}
