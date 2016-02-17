package cap2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElement {
    
    private static final List<String> friends
            = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    
    // forma tradicional
    public static void pickName(
        final List<String> names, final String startingLetter){
        
        String foundName = null;
        for(String name : names){
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        
        System.out.print(String.format("A name starting width %s: ", startingLetter));
        
        if(foundName != null){
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }
    
    // otra aproximación, usando lambdas
    public static void pickName2(
        final List<String> names, final String startingLetter){
    
        final Optional<String> foundName = 
                names.stream()
                    .filter(name -> name.startsWith(startingLetter))
                    .findFirst();
        
        System.out.println(String.format("A name starting width %s: %s", startingLetter,
                        foundName.orElse("No name found")));
    }
    
    // otra forma de tratar, si es encontrado
    public static void pickName3(
            final List<String> names, final String startingLetter) {

        final Optional<String> foundName = 
                names.stream()
                    .filter(name -> name.startsWith(startingLetter))
                    .findFirst();

        System.out.println(String.format("A name starting width %s: %s", startingLetter,
                foundName.orElse("No name found")));
        
        foundName.ifPresent(name -> System.out.println("Hello " + name));
    }
    
    public static void main(String[] args) {
        pickName(friends, "N");
        pickName(friends, "Y");
        
        System.out.println("Using lambdas:");
        pickName2(friends, "N");
        pickName2(friends, "Y");
        
        System.out.println("Using lambdas: otra forma");
        pickName3(friends, "N");
        pickName3(friends, "Y");
    }
}
