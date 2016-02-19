package cap2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningElements {
    final static List<String> friends
            = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String[] args) {
        
        // imprimir una lista de friends, separados por coma
        // forma tradicional
        for(String name : friends){
            System.out.print(name + ", ");
        }
        System.out.println("");
        
        // para arrglar el problea de la coma final, lo podemos hacer con el 
        // loop antiguo
        for(int i = 0; i < friends.size() - 1; i++){
            System.out.print(friends.get(i) + ", ");
        }
        if(friends.size() > 0){
            System.out.println(friends.get(friends.size() - 1));
        }
        
        // con Java 8 lo podemos hacer asi:
        System.out.println(String.join(", ", friends));
        
        // o podemos usar un collect y realizar unas transformaciones intermedias
        System.out.println(
            friends.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
    }
}
