public class Bytecode {
    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        Bytecode d = new Bytecode();
        System.out.println(d.square(5));
    }
}
