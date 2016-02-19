package cap3;

public class IteratingString {
    
    public static void main(String[] args) {
        final String str = "w00t";
        
        // iterando usando el nuevo método chasr() de la clase String
        str.chars().forEach(ch -> System.out.println(ch));
        
        System.out.println("");
        // usando una referencia al metodo
        str.chars().forEach(System.out::println);
        
        System.out.println("");
        // usando un método que imprima un caracter tomado un valor entero
        str.chars().forEach(IteratingString::printChar);
        
        System.out.println("");
        // si no queremos usar un metodo externo, lo podemos hacer así
        str.chars()
           .map(ch -> Character.valueOf((char)ch))
           .forEach(System.out::println);
        
        System.out.println("");
        // o podemos filtrarla
        str.chars()
           .filter(ch -> Character.isDigit(ch))
           .forEach(ch -> printChar(ch));
        
        System.out.println("");
        // hasta se puede hacer referencia a cada metodo
        str.chars().filter(Character::isDigit).forEach(IteratingString::printChar);
    }
    
    private static void printChar(int aChar) {
        System.out.println((char) (aChar));
    }
}
