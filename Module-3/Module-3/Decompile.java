public class Decompile {
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        Decompile obj = new Decompile();
        String message = obj.greet("Yashaswini");
        System.out.println(message);
    }
}
