package cap2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReducingCollectionToASingleElement {
    
    final static List<String> friends
            = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String[] args) {
        
        // determinar elnúmero total de caracteres
        System.out.println("Total number of characters in all names: " + 
                friends.stream()
                        .mapToInt(name -> name.length())
                        .sum());

        // seleccionar el que contenga mas caracteres
        System.out.println("Seleccionar el de mas caracteres: ");
        final Optional<String> aLongName = 
                friends.stream()
                        .reduce((name1, name2) -> name1.length() >= name2.length()? name1: name2);
        aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));
    }
}
