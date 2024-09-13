import java.util.Arrays;

public class Main 
{
    public static void quickSort(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot) 
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 6, 5, 12, 45, 29, 2, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Boolean isUnique = uniqueNumber(arr);
        System.out.println("Array has all unique numbers: " + isUnique);   
    }

    public static Boolean uniqueNumber(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[i] == arr[j]) 
                {
                    return false;
                }
            }
        }
        return true;
    }
}
