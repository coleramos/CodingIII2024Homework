package drive;

//linked list is a collection/list of nodes
public class SinglyLinkedList 
{
    private SinglyLinkedListNode header;
    private int length; //not necessary

    public SinglyLinkedList() {
        this.header = null;
        this.length = 0;
    }

    //O(n)
    public int getLength() {
        int len = 0;
        SinglyLinkedListNode node = this.header;
        while (node != null) {
            len++;
            node = node.nextNode;
        }
        return len;
    }

    public boolean isEmpty() {
        return this.header == null;
    }

    //Append: add to the end to the node
    //O(n)
    public void append(int value) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		if (this.isEmpty()) {
			this.header = newNode;
		} else {
			SinglyLinkedListNode tail = this.header;
			while (tail.nextNode != null) {
				tail = tail.nextNode;
			}
			tail.nextNode = newNode;
		}
		this.length++;
    }

    //Prepend: add to the front
    //O(1)
    public void prepend(int value) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
        newNode.nextNode = this.header;
        this.header = newNode;
        this.length++;
    }

    //InsertAfter
    //O(1)
    public void insertAfter(SinglyLinkedListNode a, int value) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		newNode.nextNode = this.header;
		this.header = newNode;
		this.length++;
    }

    //Remove: delete the node from the list
    //return: does the remove action complete
    //O(n)
    public boolean remove(SinglyLinkedListNode node) {
        if (this.isEmpty()) {
            return false;
        }
        if (this.header == node) {
            this.header = this.header.nextNode;
        } else {
            SinglyLinkedListNode current = this.header;
            while (current.nextNode != null && current.nextNode != node) {
                current = current.nextNode;
            }
            if (current.nextNode != null) {
                current.nextNode = current.nextNode.nextNode;
            } else {
                return false; // node not found in the list
            }
        }
        this.length--;
        return true;
    }

    //Search: return the first node that match the value to search
    //O(n)
    public SinglyLinkedListNode search(int value) {
        SinglyLinkedListNode current = this.header;
        while (current != null) {
            if (current.payload == value) {
                return current;
            }
            current = current.nextNode;
        }
        return null;
    }

    //Print
    public void print() {
        System.out.println(this);
    }

    //object-oriented programming
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "(0){empty}";
        }
        SinglyLinkedListNode current = this.header;
        StringBuilder sb = new StringBuilder("(").append(this.getLength()).append("){");
        while (current != null) {
            sb.append(current.payload);
            if (current.nextNode != null) {
                sb.append(", ");
            }
            current = current.nextNode;
        }
        sb.append("}");
        return sb.toString();
    }

    //PrintReverse
    public void printReverse() {
        if (this.isEmpty()) {
            System.out.println("(0){empty}");
        } else {
            StringBuilder sb = new StringBuilder("(").append(this.getLength()).append("){");
            SinglyLinkedListNode[] nodes = new SinglyLinkedListNode[this.length];
            SinglyLinkedListNode current = this.header;
            for (int i = this.length - 1; i >= 0; i--) {
                nodes[i] = current;
                current = current.nextNode;
            }
            for (int i = 0; i < this.length; i++) {
                sb.append(nodes[i].payload);
                if (i < this.length - 1) {
                    sb.append(" < ");
                }
            }
            sb.append("}");
            System.out.println(sb.toString());
        }
    }

    //Sort
    public void sort(boolean ascending) 
	{
		if (header == null || header.nextNode == null) return;
		boolean swapped;
		SinglyLinkedListNode current;
	
		do {
			swapped = false;
			current = header;
	
			while (current.nextNode != null) {
				if ((ascending && current.payload > current.nextNode.payload) ||
					(!ascending && current.payload < current.nextNode.payload)) 
					{
					int temp = current.payload;
					current.payload = current.nextNode.payload;
					current.nextNode.payload = temp;
	
					swapped = true;
				}
				current = current.nextNode;
			}
		} 
		while (swapped);
	}

	public String toStringPayloads() {
		StringBuilder sb = new StringBuilder();
		SinglyLinkedListNode current = this.header;
		while (current != null) {
			sb.append(current.payload);
			if (current.nextNode != null) {
				sb.append(", ");
			}
			current = current.nextNode;
		}
		return sb.toString();
	}
}