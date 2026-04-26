import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

        List<String> names = Arrays.asList(
                "Ali", "Mona", "Ahmed", "Sara", "Amr",
                "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        List<Student> students = Arrays.asList(
                new Student("Ali",   "IT", 85),
                new Student("Mona",  "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara",  "CS", 70),
                new Student("Omar",  "IS", 45),
                new Student("Laila", "IS", 78));

        List<Employee> employees = Arrays.asList(
                new Employee("Ali",   30, "HR",      5000),
                new Employee("Mona",  25, "IT",      7000),
                new Employee("Ahmed", 30, "HR",      5500),
                new Employee("Sara",  27, "IT",      7200),
                new Employee("Omar",  40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200));

        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java",    "Stream"),
                Arrays.asList("API",     "Lambda"),
                Arrays.asList("FlatMap", "Map"));


        // Basic stream operations

        // Filter even numbers from the list
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("1. even numbers: " + evenNumbers);

        // Find names that start with the letter A
        List<String> namesStartingWithA = names.stream()
                .filter(n -> n != null && n.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("2. names starting with A: " + namesStartingWithA);

        // Convert all names to uppercase
        List<String> upperCaseNames = names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("3. uppercase names: " + upperCaseNames);

        // Sort numbers in descending order
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("4. sorted descending: " + sortedDesc);

        // Remove duplicate numbers from the list
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("5. distinct numbers: " + uniqueNumbers);


        // Intermediate stream tasks

        // Count how many names have more than 5 characters
        long countLongNames = names.stream()
                .filter(n -> n != null && n.length() > 5)
                .count();
        System.out.println("6. names longer than 5 chars: " + countLongNames);

        // Find the first number that is divisible by 3
        Optional<Integer> firstDivBy3 = numbers.stream()
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println("7. first number divisible by 3: " + firstDivBy3.orElse(-1));

        // Check if any number in the list is divisible by 5
        boolean anyDivBy5 = numbers.stream()
                .anyMatch(n -> n % 5 == 0);
        System.out.println("8. any number divisible by 5: " + anyDivBy5);

        // Collect all numbers into a Set to remove duplicates automatically
        Set<Integer> numberSet = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println("9. numbers as a set: " + numberSet);

        // Skip the first 3 elements and return the rest
        List<Integer> afterSkip = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("10. after skipping 3: " + afterSkip);


        // Numeric streams and reductions

        // Sum all integers using reduce
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("11. sum: " + sum);

        // Find the max and min values in the list
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("12. max: " + max.orElse(null) + ", min: " + min.orElse(null));

        // Calculate the average of all numbers
        OptionalDouble average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        System.out.println("13. average: " + String.format("%.2f", average.orElse(0.0)));

        // Multiply all non-zero numbers together
        long product = numbers.stream()
                .filter(n -> n != 0)
                .mapToLong(Integer::longValue)
                .reduce(1L, (a, b) -> a * b);
        System.out.println("14. product (zeros excluded): " + product);

        // Count how many numbers are positive
        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("15. positive count: " + positiveCount);


        // Collectors and grouping

        // Group students by their department
        Map<String, List<Student>> byDepartment = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println("16. students by department: " + byDepartment);

        // Partition numbers into even and odd groups
        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("17. even: " + evenOddPartition.get(true));
        System.out.println("17. odd:  " + evenOddPartition.get(false));

        // Join all valid names into a single comma-separated string
        String csv = names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .collect(Collectors.joining(", "));
        System.out.println("18. csv: " + csv);

        // Group employees by age and count how many are in each age group
        Map<Integer, Long> countByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        System.out.println("19. employee count by age: " + countByAge);

        // Calculate the average salary per department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("20. avg salary by department: " + avgSalaryByDept);


        // Optional, map, and flatMap

        // Flatten the nested list of lists into one flat list
        List<String> flatList = nestedWords.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("21. flattened list: " + flatList);

        // Extract all unique characters from all the words
        Set<Character> uniqueChars = nestedWords.stream()
                .flatMap(Collection::stream)
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toSet());
        System.out.println("22. unique characters: " + uniqueChars);

        // Filter out empty Optionals and collect the values that are present
        List<Optional<String>> optionals = Arrays.asList(
                Optional.of("Hello"), Optional.empty(),
                Optional.of("World"), Optional.empty());
        List<String> presentValues = optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        System.out.println("23. present optional values: " + presentValues);

        // Map each name to its length
        List<Integer> nameLengths = names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("24. name lengths: " + nameLengths);

        // Return uppercased names that start with A
        List<String> upperStartingWithA = names.stream()
                .filter(n -> n != null && n.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("25. uppercased names starting with A: " + upperStartingWithA);


        // Advanced operations

        // Sort employees by salary ascending, then by name if salary is the same
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("26. sorted by salary then name: " + sortedEmployees);

        // Find the second highest unique number in the list
        Optional<Integer> secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("27. second highest: " + secondHighest.orElse(null));

        // Find numbers that appear more than once in the list
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());
        System.out.println("28. duplicates: " + duplicates);

        // Remove null and empty strings from the names list
        List<String> cleanNames = names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .collect(Collectors.toList());
        System.out.println("29. clean names: " + cleanNames);

        // Partition students into pass and fail based on grade
        Map<Boolean, List<Student>> passFail = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= 60));
        System.out.println("30. pass: " + passFail.get(true));
        System.out.println("30. fail: " + passFail.get(false));
    }
}
