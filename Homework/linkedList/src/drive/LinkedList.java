package drive; 

public class LinkedList 
{
    Node head;

    public LinkedList() 
    {
        head = null;
    }

    class Node 
    {
        int data;
        Node next;

        Node(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) 
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) 
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printList() 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void deleteNode(int key) 
    {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) 
        {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) 
        {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) 
        {
            System.out.println("Node with value " + key + " not found.");
            return;
        }
        prev.next = temp.next;
    }

    public void insertAt(int position, int data)
    {
        Node newNode = new Node(data);
        if (position == 0) 
        {
            addFirst(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position && temp != null; i++) 
        {
            temp = temp.next;
        }
        if (temp == null) 
        {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void swap(int data1, int data2) 
    {
        if (data1 == data2) return;

        Node prevX = null, currX = head;
        while (currX != null && currX.data != data1) 
        {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != data2) 
        {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) return;

        if (prevX != null) prevX.next = currY;
        else head = currY;

        if (prevY != null) prevY.next = currX;
        else head = currX;

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }


    public boolean search(int key) 
    {
        Node temp = head;
        while (temp != null) 
        {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

   
    public boolean isEmpty() 
    {
        return head == null;
    }

    
    public int getLength() 
    {
        int length = 0;
        Node temp = head;
        while (temp != null) 
        {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) 
    {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addFirst(5);
        list.addLast(15);
        list.printList(); 
        
        list.insertAt(1, 7);
        list.printList();  

        list.swap(7, 15);
        list.printList();  

        System.out.println("Found 10: " + list.search(10)); 
        System.out.println("List is empty: " + list.isEmpty()); 
        System.out.println("List length: " + list.getLength()); 
    }
}
