package drive;

public class Main {

	public static void main(String[] args) {
		System.out.println("SinglyLinkedList in Bubble Sort");
		SinglyLinkedList list = new SinglyLinkedList();
		list.append(17);
		list.prepend(9);
		list.append(5);
		
		list.sort(true);
		list.print();
	}

}