import java.util.Arrays;

public class Main 
{
    public static void quickSort(char[] arr, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(char[] arr, int low, int high)
    {
        char pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot) 
            {
                i++;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args)
    {
        char[] arr = {'c', 'o', 'l' , 'e', 'r', 'a', 'm', 'o', 's'};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Boolean isUnique = uniqueCharacters(arr);
        System.out.println("Array has all unique characters: " + isUnique);   
    }

    public static Boolean uniqueCharacters(char[] arr)
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
