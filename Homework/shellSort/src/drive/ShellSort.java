package drive;

public class ShellSort 
{
    public static void shellSort(int[] array) {
        // Generate the gap sequence: 2^k - 1
        int n = array.length;
        int gap = 1;
        while (gap < n / 2) {
            gap = 2 * gap + 1;
        }

        // Perform sorting based on the generated gap sequence
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            gap /= 2;
        }
    }
}