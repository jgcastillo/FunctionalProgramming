package cap2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Casper
 */
public class Iteractions {
    public static void main(String[] args) {
        final List<String> friends
                = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        
        // impresion, primera aproximación
        for(int i = 0; i < friends.size(); i++ ){
            System.out.println(friends.get(i));
        }
        
        // impresion tradicional
        for(String name : friends){
            System.out.println(name);
        }
        
        // usando una clase anónima
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });
        
        // usando lambdas
        friends.forEach((final String name) -> System.out.println(name));
        
        // mas conciso, cun una referencia a un método
        friends.forEach(System.out::println);
    }
    
}
