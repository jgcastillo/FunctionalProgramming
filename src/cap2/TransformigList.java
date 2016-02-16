package cap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Casper
 */
public class TransformigList {
    public static void main(String[] args) {
        final List<String> friends
                = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        
        // creando una lista con los nombres en mayuscula
        final List<String> uppercaseNames = new ArrayList<>();
        for(String name : friends){
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(uppercaseNames);
        System.out.println("");
        
        // usemos un internal iterator, forEach
        final List<String> uppercaseNames2 = new ArrayList<>();
        
        friends.forEach(name -> uppercaseNames2.add(name.toUpperCase()));
        System.out.println(uppercaseNames2);
        System.out.println("");
        
        // usemos una expresión lambda
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));
        System.out.println("");
        
        // ... podemos cambiar la salida sin usar otra variable
        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + " "));
                
    }
}
