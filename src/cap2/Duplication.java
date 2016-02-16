package cap2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Casper
 */
public class Duplication {
    public static void main(String[] args) {
        final List<String> friends
                = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> comrades
                = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
        final List<String> editors
                = Arrays.asList("Brian", "Jackie", "John", "Mike");
        
        System.out.println("Duplicando código");
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB = name -> name.startsWith("B");
        
        final long countFriendsStartN =
                friends.stream().filter(startsWithN).count();
        final long countFriendsStartB
                = friends.stream().filter(startsWithB).count();
        System.out.println(String.format(" %d friends starts with N", countFriendsStartN));
        System.out.println(String.format(" %d friends starts with B", countFriendsStartB));
        
        // eliminado la duplicación, usando lexical scope
        System.out.println("usando un lexical scope");
        final long countFriendsStartN1
                = friends.stream().filter(checkIfStartWith("N")).count();
        final long countFriendsStartB1
                = friends.stream().filter(checkIfStartWith("B")).count();
        System.out.println(String.format(" %d friends starts with N", countFriendsStartN1));
        System.out.println(String.format(" %d friends starts with B", countFriendsStartB1));
        
        
        // estrechando el alcance, para no usar el mètodo static definido, 
        // usamos una Function
        System.out.println("usando un Function");
        final Function<String, Predicate<String>> startsWithLetter
                = (String letter) -> {
                    Predicate<String> checkStartsWith
                    = (String name) -> name.startsWith(letter);
                    return checkStartsWith;
                };
        final long countFriendsStartN2
                = friends.stream().filter(startsWithLetter.apply("N")).count();
        final long countFriendsStartB2
                = friends.stream().filter(startsWithLetter.apply("B")).count();
        System.out.println(String.format(" %d friends starts with N", countFriendsStartN2));
        System.out.println(String.format(" %d friends starts with B", countFriendsStartB2));
        
        // escribiendo la Function más concisa
        System.out.println("reescribiendo la Function");
        final Function<String, Predicate<String>> startsWithLetter2
                = (String letter) -> (String name) -> name.startsWith(letter);
        
        // aún más concisa
        final Function<String, Predicate<String>> startsWithLetter3
                = letter -> name -> name.startsWith(letter);
        final long countFriendsStartN3
                = friends.stream().filter(startsWithLetter3.apply("N")).count();
        final long countFriendsStartB3
                = friends.stream().filter(startsWithLetter3.apply("B")).count();
        System.out.println(String.format(" %d friends starts with N", countFriendsStartN3));
        System.out.println(String.format(" %d friends starts with B", countFriendsStartB3));
        
    }
    
    public static Predicate<String> checkIfStartWith(final String letter){
        return name -> name.startsWith(letter);
    }
}
