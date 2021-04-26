package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Arrays.stream(scanner.nextLine().split("\\s+")).forEach(name-> System.out.println(name));

        // Consumer <параметър, който приема>
        // Function <параметър, който приема; типа на резултата>
        // Predicate <приема> -> return boolean

        Consumer<String> consumer = (String name) -> System.out.println(name);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);

    }
}
