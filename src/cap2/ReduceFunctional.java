package cap2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jgcastillo
 */
public class ReduceFunctional {

    static List<Person> persons = Arrays.asList(
            new Person("Max", 18),
            new Person("Peter", 23),
            new Person("Pamela", 23),
            new Person("David", 12));
    
    public static void main(String[] args) {
        persons.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out:: println);
    }
}
