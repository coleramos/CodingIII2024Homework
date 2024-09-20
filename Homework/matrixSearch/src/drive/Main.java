package drive;

public class Main
{
	public static void main(String[] args)
	{
	//array of array
	int[][] matrix = new int[][]
	{
		{1, 2, 3, 4},
		{5, 6, 7, 8},
		{9, 10, 11, 12}
	};
			
			if(matrix.length > 0)
			{
				for(int y = 0; y < matrix.length; y++)
				{
					for(int x = 0; x < matrix[0].length; x++)
					{
						System.out.println("The item at row index = " + y + " column index = " + x + " is " + matrix[y][x]);
					}
				}
			}
			int[] result = BinarySearch(matrix, 6);
			System.out.println(result[0] + ":" + result[1]);
	}
	
	//1. scan through all the rows, and run binary search for each row
	//2. map the matrix onto the 1-d array and get the index from 1-d array BinarySearch and map it back to the 2d matrix indexs
	//3. range BinarySearch to return row index, and BinarySearch to return column index
	public static int[] BinarySearch(int[][] matrix, int query)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int start = 0;
		int end = rows * columns - 1;
		while(start <= end)
		{
			int mid = (start + end) / 2;
			int r = mid / columns;
			int c = mid % columns;
			if(matrix[r][c] == query)
			{
				return new int[] {r, c};
			}
			else
			{
				if(matrix[r][c] < query)
				{
					start = mid + 1;
				}
				else
				{
					end = mid - 1;
				}
			}
		}
		return new int[] {-1, -1};
	}
}