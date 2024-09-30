package drive;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        int[] bubbleArr = new int[10000];
        int[] selectionArr = new int[10000];
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            bubbleArr[i] = random.nextInt(100000);
            selectionArr[i] = bubbleArr[i];
        }

        long bubbleStart = System.currentTimeMillis();
        bubbleSort(bubbleArr);
        long bubbleEnd = System.currentTimeMillis();
        System.out.println("Time it took for an array size of " + (bubbleStart) + " in bubbleSort: " + (bubbleEnd - bubbleStart) + " ms");

        long selectionStart = System.currentTimeMillis();
        selectionSort(selectionArr);
        long selectionEnd = System.currentTimeMillis();
        System.out.println("Time it took for an array size of " + (selectionStart) + " in selectionSort: " + (selectionEnd - selectionStart) + " ms");
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int min = numbers[i];
            int indexMin = i;
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    indexMin = j;
                }
            }
            swap(numbers, i, indexMin);
        }
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}