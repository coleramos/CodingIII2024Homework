package drive;

public class Main {
    public static void main(String[] args) {
        doublyLinkedList doublyList = new doublyLinkedList();
        doublyLinkedList.LinkedList list = doublyList.new LinkedList();

        // Add nodes to the list
        list.append(doublyList.new Node(12));
        list.append(doublyList.new Node(31));
        list.append(doublyList.new Node(98));
        list.append(doublyList.new Node(16));
        list.append(doublyList.new Node(24));

        System.out.println("Original list:");
        list.printList();

        // Sort in ascending order
        doublyLinkedListSort.Sort(list, true);
        System.out.println("List sorted in ascending order:");
        list.printList();

        // Sort in descending order
        doublyLinkedListSort.Sort(list, false);
        System.out.println("List sorted in descending order:");
        list.printList();
    }
}
