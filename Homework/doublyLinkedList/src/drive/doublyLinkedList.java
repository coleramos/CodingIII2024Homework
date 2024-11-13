package drive;

public class doublyLinkedList {
    public class Node {
        public int data;
        public Node next;
        public Node previous;

        public Node(int initialData) {
            data = initialData;
            next = null;
            previous = null;
        }

        public int compareTo(Node another) {
            if (this.data > another.data) return 1;
            else if (this.data < another.data) return -1;
            else return 0;
        }
    }

    public class LinkedList {
        protected Node m_head;
        protected Node m_tail;

        public LinkedList() {
            m_head = null;
            m_tail = null;
        }

        public void append(Node newNode) {
            if (m_head == null) {
                m_head = newNode;
                m_tail = newNode;
            } else {
                m_tail.next = newNode;
                newNode.previous = m_tail;
                m_tail = newNode;
            }
        }

        public void printList() {
            Node node = m_head;
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}

