package src;

public class main {
	
	public static final int arrayLength = 10;
	
	public static void main(String[] args) {
		int baseArray[][] = {
		        {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
		        {0, 9, 8, 7, 6, 5, 4, 3, 2, 1},
		        {1, 3, 5, 7, 9, 2, 4, 6, 8, 0},
		        {0, 8, 6, 4, 2, 9, 7, 5, 3, 1},
		        {0, 1, 2, 3, 4, 5, 4, 3, 2, 1},
		        {9, 8, 7, 6, 5, 6, 7, 8, 9, 0},
		        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
		        {9, 8, 7, 6, 7, 8, 9, 8, 7, 6},
		        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		        };
			
			for(int i = 0;i < 4;i++)
			{
				baseArray = rotate(baseArray);
				printArray(baseArray);	
			}
	}
	public static void printArray(int[][] inArray)
	{
		for(int i = 0; i < arrayLength ; i++){
			for(int j = 0; j < arrayLength; j++){
				System.out.print(inArray[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("\n");
	}
	public static int[][] rotate(int[][] inArray)
	{
		int resultArray[][] = new int[arrayLength][arrayLength];
		
		for(int i = 0; i < arrayLength ; i++){
			for(int j = 0; j < arrayLength; j++){
				resultArray[i][j] = inArray[j][arrayLength - i - 1];
			}
		}
		inArray = resultArray;
		
		return resultArray;
	}
}
