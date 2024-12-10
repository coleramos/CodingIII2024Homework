package drive;

import java.util.Random;

public class Main 
{
    public static void main(String[] args) 
    {
        HashTable hashTable = new HashTable();
        Random random = new Random();

        System.out.println("Inserting 20 random pairs:");
        for (int i = 0; i < 20; i++) 
        {
            int key = random.nextInt(100);
            int value = random.nextInt(100);
            hashTable.insert(key, value);
            System.out.println("Inserted Key: = " + key + ", Value = " + value);
        }

        // Display the table
        hashTable.display();

        // Remove two keys
        System.out.println("\nRemoving two keys:");
        hashTable.remove(20);
        hashTable.remove(10);
        hashTable.display();

        System.out.println("\nSearching:");
        Integer key1 = 25;
        Integer key2 = 50;
        System.out.println("Search Key = " + key1 + ", Value = " + hashTable.search(key1));
        System.out.println("Search Key = " + key2 + ", Value = " + hashTable.search(key2));
    }
    
    static class HashTable 
    {
        private int size = 10;
        private Entry[] table;

        private class Entry {
            Integer key;
            Integer value;

            Entry(Integer key, Integer value) 
            {
                this.key = key;
                this.value = value;
            }
        }

        public HashTable() 
        {
            table = new Entry[size];
        }

        private int hash(Integer key) 
        {
            return key % size;
        }

        public void insert(Integer key, Integer value) 
        {
            int index = hash(key);
            int originalIndex = index;
            while (table[index] != null && table[index].key != null) 
            {
                index = (index + 1) % size;
                if (index == originalIndex) { // Table is full
                    System.out.println("HashTable is full. Cannot insert " + key);
                    return;
                }
            }
            table[index] = new Entry(key, value);
        }

        public void remove(Integer key) 
        {
            int index = hash(key);
            int originalIndex = index;
            while (table[index] != null) 
            {
                if (table[index].key != null && table[index].key.equals(key)) 
                {
                    table[index].key = null; // Mark as deleted
                    table[index].value = null;
                    return;
                }
                index = (index + 1) % size;
                if (index == originalIndex) 
                {
                    break;
                }
            }
            System.out.println("Key " + key + " not found.");
        }

        public Integer search(Integer key) 
        {
            int index = hash(key);
            int originalIndex = index;
            while (table[index] != null) 
            {
                if (table[index].key != null && table[index].key.equals(key)) 
                {
                    return table[index].value;
                }
                index = (index + 1) % size;
                if (index == originalIndex) 
                {
                    break;
                }
            }
            return null;
        }

        public void display() {
            System.out.println("Hash Table:");
            for (int i = 0; i < size; i++) {
                if (table[i] != null && table[i].key != null) 
                {
                    System.out.println("Index " + i + ": Key = " + table[i].key + ", Value = " + table[i].value);
                } else 
                {
                    System.out.println("Index " + i + ": Empty");
                }
            }
        }
    }
}

