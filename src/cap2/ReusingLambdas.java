package cap2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Casper
 */
public class ReusingLambdas {
    public static void main(String[] args) {
        final List<String> friends
                = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> comrades
                = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
        final List<String> editors
                = Arrays.asList("Brian", "Jackie", "John", "Mike");
        
        // primera aproximación, una lambda para cada lista
        final long countFriendsStartN
                = friends.stream().filter(name -> name.startsWith("N")).count();
        final long countComradesStartN
                = comrades.stream().filter(name -> name.startsWith("N")).count();
        final long countEditorsStartN
                = editors.stream().filter(name -> name.startsWith("N")).count();
        
        // refactorizemos, para hacerlo mas conciso
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final long countFriendsStartN1
                = friends.stream().filter(startsWithN).count();
        final long countComradesStartN1
                = comrades.stream().filter(startsWithN).count();
        final long countEditorsStartN1
                = editors.stream().filter(startsWithN).count();
    }
}
