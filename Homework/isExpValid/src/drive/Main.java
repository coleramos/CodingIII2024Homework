package drive;

public class Main {

    // Stack Interface
    public interface StackInterface {
        void push(String value);
        String pop();
        boolean isEmpty();
    }

    // LinkedListStack Implementation
    public static class LinkedListStack implements StackInterface {
        private Node top;

        // Node Class
        private static class Node {
            public String payload;
            public Node nextNode;
            public Node preNode;

            public Node(String payload) {
                this.payload = payload;
                this.nextNode = null;
                this.preNode = null;
            }
        }

        public LinkedListStack() {
            this.top = null;
        }

        @Override
        public void push(String value) {
            Node newNode = new Node(value);
            newNode.nextNode = this.top;
            if (this.top != null) {
                this.top.preNode = newNode;
            }
            this.top = newNode;
        }

        @Override
        public String pop() {
            if (this.top == null) {
                return null;
            }
            String value = this.top.payload;
            this.top = this.top.nextNode;
            return value;
        }

        @Override
        public boolean isEmpty() {
            return this.top == null;
        }
    }

    // ArrayStack Implementation
    public static class ArrayStack implements StackInterface {
        private String[] stack;
        private int top;

        public ArrayStack(int capacity) {
            stack = new String[capacity];
            top = -1;
        }

        @Override
        public void push(String value) {
            if (top == stack.length - 1) {
                throw new StackOverflowError("Stack is full");
            }
            stack[++top] = value;
        }

        @Override
        public String pop() {
            if (isEmpty()) {
                return null;
            }
            return stack[top--];
        }

        @Override
        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Method to validate mathematical expressions
    public static boolean isExpValid(StackInterface stack, String expr) {
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == '(') {
                stack.push(String.valueOf(c));
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // Main Method
    public static void main(String[] args) {
        StackInterface linkedListStack = new LinkedListStack();
        StackInterface arrayStack = new ArrayStack(100);

        String expr1 = "(1 + 2 * (3 - 1) ) / (1 + 1)";
        String expr2 = "(1 + 2 * (3 - 1) / (1 + 1)";

        // Test with LinkedListStack
        System.out.println("Is expression 1 valid with LinkedListStack? " + isExpValid(linkedListStack, expr1));
        System.out.println("Is expression 2 valid with LinkedListStack? " + isExpValid(linkedListStack, expr2));

        // Test with ArrayStack
        System.out.println("Is expression 1 valid with ArrayStack? " + isExpValid(arrayStack, expr1));
        System.out.println("Is expression 2 valid with ArrayStack? " + isExpValid(arrayStack, expr2));
    }
}

