import java.util.Scanner;

public class OperatorPrecedence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number (a): ");
        int a = scanner.nextInt();

        System.out.print("Enter second number (b): ");
        int b = scanner.nextInt();

        System.out.print("Enter third number (c): ");
        int c = scanner.nextInt();

        int result1 = a + b * c;
        System.out.println("\nExpression: a + b * c");
        System.out.println("Evaluated as: " + a + " + " + b + " * " + c);
        System.out.println("According to operator precedence, multiplication is performed before addition.");
        System.out.println("Result: " + result1);

        int result2 = (a + b) * c;
        System.out.println("\nExpression: (a + b) * c");
        System.out.println("Evaluated as: (" + a + " + " + b + ") * " + c);
        System.out.println("Parentheses have the highest precedence, so addition is performed first.");
        System.out.println("Result: " + result2);

        int result3 = a + b * c / 2;
        System.out.println("\nExpression: a + b * c / 2");
        System.out.println("Evaluated as: " + a + " + (" + b + " * " + c + ") / 2");
        System.out.println("Multiplication and division have the same precedence and are evaluated left to right.");
        System.out.println("Result: " + result3);

        scanner.close();
    }
}
