package drive;
import java.util.Random;

public class Benchmark 
{
    public static void main(String[] args) {
        int size = 10_000_000;
        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Run " + i + " for Shell Sort:");
            int[] shellSortArray = random.ints(size, 0, 100_000_000).toArray();
            long startShellSort = System.currentTimeMillis();
            ShellSort.shellSort(shellSortArray);
            long endShellSort = System.currentTimeMillis();
            System.out.println("Shell Sort took: " + (endShellSort - startShellSort) + " ms");

            System.out.println("Run " + i + " for Quick Sort:");
            int[] quickSortArray = random.ints(size, 0, 100_000_000).toArray();
            long startQuickSort = System.currentTimeMillis();
            QuickSort.quickSort(quickSortArray, 0, quickSortArray.length - 1);
            long endQuickSort = System.currentTimeMillis();
            System.out.println("Quick Sort took: " + (endQuickSort - startQuickSort) + " ms");
        }
    }

}
