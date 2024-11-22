package drive;

public class Main {
    public static void main(String[] args) {
        String exp = "4^2+18/(9-3)";
        try {
            TokenList list = ShuntingYard.ParseFromExp(exp);
            System.out.println("Parsed Tokens: " + list);

            TokenList queue = ShuntingYard.BuildFromTokens(list);
            System.out.println("Reverse Polish Notation: " + queue);

            int result = ShuntingYard.Process(queue);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
