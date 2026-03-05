import java.util.ArrayList;
import java.util.Collections;

public class K {
    void divisors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (i * i != n) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}