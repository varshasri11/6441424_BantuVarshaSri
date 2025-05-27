import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflect2 {
    public static void main(String[] args) throws Exception {
        // Load the Sample class dynamically
        Class<?> cls = Class.forName("Reflect1");

        // Create an instance of the Sample class
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Get all declared methods
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("Method: " + method.getName());

            // Print parameter types
            Parameter[] params = method.getParameters();
            for (Parameter param : params) {
                System.out.println("  Parameter: " + param.getType().getSimpleName() + " " + param.getName());
            }

            // Dynamically invoke method based on its name
            if (method.getName().equals("sayHello")) {
                method.invoke(obj, "Yashaswini");
            } else if (method.getName().equals("add")) {
                Object result = method.invoke(obj, 5, 7);
                System.out.println("  Result of add: " + result);
            }
        }
    }
}
