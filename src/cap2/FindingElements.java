package cap2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Casper
 */
public class FindingElements {
    
    private static final List<String> friends
                = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    public static void main(String[] args) {
        // buscar elementos en una lista
        final List<String> startsWithN = 
                friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .collect(Collectors.toList());
        System.out.println(startsWithN);
        System.out.println(String.format("Found %d names", startsWithN.size()));
    }
}
