import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

        System.out.println(numbers.stream().reduce(0, Integer::sum));

        System.out.println(numbers.stream().max(Integer::compareTo).get());
        System.out.println(numbers.stream().min(Integer::compareTo).get());

        System.out.println(numbers.stream().mapToInt(Integer::intValue).average().getAsDouble());

        System.out.println(numbers.stream().reduce(1, (a, b) -> a * b));

        System.out.println(numbers.stream().filter(n -> n > 0).count());
    }
}