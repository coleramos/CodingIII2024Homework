package drive;

public class TokenList extends DoublyLinkedList<String> implements iQueue<String>, iStack<String> {
    public static String Operators = "+-*/^()";
    public static String Numbers = "1234567890";

    @Override
    public void Push(Node<String> node) {
        this.InsertAfter(this.Tail, node);
    }

    @Override
    public Node<String> Pop() {
        if (this.IsEmpty()) {
            return null;
        }
        Node<String> ret = this.Tail;
        this.Remove(ret);
        return ret;
    }

    @Override
    public void Enqueue(Node<String> node) {
        this.InsertAhead(this.Head, node);
    }

    @Override
    public Node<String> Dequeue() {
        return this.Pop();
    }

    @Override
    public Node<String> Peek() {
        return this.Tail;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<String> node = this.Head;
        while (node != null) {
            str.append(node.Payload).append(" ");
            node = node.NextNode;
        }
        return str.toString().trim();
    }
}
