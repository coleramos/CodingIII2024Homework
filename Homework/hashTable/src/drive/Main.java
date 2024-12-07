package drive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class HashTable 
{
    private ArrayList<LinkedList<Entry>> table;
    private int size;

    public static void main(String[] args) 
    {
        HashTable hashTable = new HashTable(10);
        Random random = new Random();

        for (int i = 0; i < 20; i++) 
        {
            int key = random.nextInt(100) + 1;
            int value = random.nextInt(100) + 1;
            hashTable.insert(key, value);
        }

        System.out.println("Hash Table after inserting 20 random pairs:");
        hashTable.display();

        int keyRemove1 = random.nextInt(100) + 1;
        int keyRemove2 = random.nextInt(100) + 1;
        System.out.println("Removing keys " + keyRemove1 + " & " + keyRemove2 + " ");
        hashTable.remove(keyRemove1);
        hashTable.remove(keyRemove2);

        System.out.println("After Removals:");
        hashTable.display();

        int keySearch1 = random.nextInt(100) + 1;
        int keySearch2 = random.nextInt(100) + 1;
        System.out.println("Searching for keys " + keySearch1 + " & " + keySearch2 + " ");
        Integer result1 = hashTable.search(keySearch1);
        Integer result2 = hashTable.search(keySearch2);

        System.out.println("Key " + keySearch1 + ": " + (result1 != null ? "Found" : "Not Found"));
        System.out.println("Key " + keySearch2 + ": " + (result2 != null ? "Found" : "Not Found"));
    }

    public HashTable(int size) 
    {
        this.size = size;
        table = new ArrayList<>();
        for (int i = 0; i < size; i++) 
        {
            table.add(new LinkedList<>());
        }
    }

    private int hashFunction(int key) 
    {
        return key % size;
    }

    public void insert(int key, int value) 
    {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table.get(index);

        for (Entry entry : bucket) 
        {
            if (entry.key == key) 
            {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }

    public boolean remove(int key) 
    {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table.get(index);
        for (Entry entry : bucket) 
        {
            if (entry.key == key) 
            {
                bucket.remove(entry);
                return true;
            }
        }
        return false;
    }
    public Integer search(int key) 
    {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table.get(index);

        for (Entry entry : bucket) 
        {
            if (entry.key == key) 
            {
                return entry.value;
            }
        }

        return null;
    }

    public void display() 
    {
        for (int i = 0; i < table.size(); i++) 
        {
            System.out.print("Index " + i + ": ");
            LinkedList<Entry> bucket = table.get(i);
            for (Entry entry : bucket) 
            {
                System.out.print("[" + entry.key + ": " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    private static class Entry 
    {
        int key, value;

        public Entry(int key, int value) 
        {
            this.key = key;
            this.value = value;
        }
    }
}