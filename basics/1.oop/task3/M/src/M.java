public class M {
    void solve(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            int m = i;
            boolean luk = true;
            while (m != 0) {
                if (m % 10 != 4 && m % 10 != 7) luk = false;
                m /= 10;
            }
            if (luk) {
                System.out.print(i + " ");
                count++;
            }
        }
        if (count == 0) {
            System.out.println(-1);
        }
    }
}