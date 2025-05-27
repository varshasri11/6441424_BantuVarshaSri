public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble;  

        System.out.println("Original double: " + myDouble);
        System.out.println("Casted to int: " + myInt);

        int intValue = 10;
        double doubleValue = intValue;  

        System.out.println("Original int: " + intValue);
        System.out.println("Casted to double: " + doubleValue);
    }
}
