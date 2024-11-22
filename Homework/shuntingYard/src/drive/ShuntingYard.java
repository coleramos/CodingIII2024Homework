package drive;

import java.util.Stack;

public class ShuntingYard {
    public static String Operators = "+-*/^()";
    public static String Numbers = "1234567890";

    public static boolean IsNumber(String input) {
        for (char c : input.toCharArray()) {
            if (Numbers.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static int getPrecedence(String input) {
        char op = input.charAt(0);
        switch (op) {
            case '(':
                return 1;
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 3;
            case '^':
                return 4;
            case ')':
                return 5;
            default:
                return 0;
        }
    }

    public static TokenList ParseFromExp(String exp) {
        TokenList lst = new TokenList();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Numbers.indexOf(c) != -1) {
                currentToken.append(c);
            } else if (Operators.indexOf(c) != -1) {
                if (currentToken.length() > 0) {
                    lst.Push(new Node<>(currentToken.toString()));
                    currentToken.setLength(0);
                }
                lst.Push(new Node<>(String.valueOf(c)));
            }
        }

        if (currentToken.length() > 0) {
            lst.Push(new Node<>(currentToken.toString()));
        }

        return lst;
    }

    public static TokenList BuildFromTokens(TokenList tokenList) {
        TokenList outputQueue = new TokenList();
        Stack<String> operatorStack = new Stack<>();

        Node<String> current = tokenList.Head;
        while (current != null) {
            String token = current.Payload;

            if (IsNumber(token)) {
                outputQueue.Push(new Node<>(token));
            } else if (Operators.indexOf(token) != -1) {
                if (token.equals("(")) {
                    operatorStack.push(token);
                } else if (token.equals(")")) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.Push(new Node<>(operatorStack.pop()));
                    }
                    operatorStack.pop();
                } else {
                    while (!operatorStack.isEmpty() &&
                           getPrecedence(operatorStack.peek()) >= getPrecedence(token) &&
                           !operatorStack.peek().equals("(")) {
                        outputQueue.Push(new Node<>(operatorStack.pop()));
                    }
                    operatorStack.push(token);
                }
            }
            current = current.NextNode;
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.Push(new Node<>(operatorStack.pop()));
        }

        return outputQueue;
    }

    public static int Process(TokenList queue) {
        Stack<Integer> evaluationStack = new Stack<>();

        Node<String> current = queue.Head;
        while (current != null) {
            String token = current.Payload;

            if (IsNumber(token)) {
                evaluationStack.push(Integer.parseInt(token));
            } else {
                int b = evaluationStack.pop();
                int a = evaluationStack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    case "^":
                        result = (int) Math.pow(a, b);
                        break;
                }
                evaluationStack.push(result);
            }

            current = current.NextNode;
        }

        return evaluationStack.pop();
    }
}
