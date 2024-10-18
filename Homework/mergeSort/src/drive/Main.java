package drive;

import java.util.Arrays;

public class Main 
{
    public static void main(String[] args) 
    {
       int[] numbers = { 61, 76, 19, 4, 94, 32, 27, 83, 58 };
       System.out.println("Unsorted Array: " + Arrays.toString(numbers));
       mergeSort(numbers, 0, numbers.length - 1);
       System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }
    
    private static void merge(int[] numbers, int i, int j, int k) 
    {
        int left = i;
        int mid = j + 1;
        int right = k + 1;
    
        while (left <= mid && mid < right) 
        {
            if (numbers[left] <= numbers[mid]) 
            {
                left++;
            }
            else 
            {
                int temp = numbers[mid];
                numbers[mid] = numbers[left];
                numbers[left] = temp;
                int shiftIndex = left;

                while (shiftIndex > i && numbers[shiftIndex - 1] > numbers[shiftIndex]) 
                {
                    temp = numbers[shiftIndex];
                    numbers[shiftIndex] = numbers[shiftIndex - 1];
                    numbers[shiftIndex - 1] = temp;
                    shiftIndex--;
                }
    
                left++;
                mid++;
            }
        }
    }
   
   private static void mergeSort(int[] numbers, int i, int k) 
   {
      int j;
      
      if (i < k) 
      {
         j = (i + k) / 2;
         mergeSort(numbers, i, j);
         mergeSort(numbers, j + 1, k);
         merge(numbers, i, j, k);
      }
   }
}
