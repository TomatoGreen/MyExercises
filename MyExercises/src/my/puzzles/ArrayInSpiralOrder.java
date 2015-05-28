package my.puzzles;

public class ArrayInSpiralOrder {

	public static void main(String[] args) {
		int array[][] = {
		      { 0,  1,  2,  3, 4},
		      {15, 16, 17, 18, 5},
		      {14, 23, 24, 19, 6},
		      {13, 22, 21, 20, 7},
		      {12, 11, 10, 9, 8}};
		
		printMatrixRecursive(array, 0, 0, 4, 4);
	}

	public static void printMatrixRecursive(int array[][], int startRow, int startCol, int endRow, int endCol) {
		if(startRow > endRow || startCol > endCol)
			return;
		
		for(int i=startRow, j=startCol; j<endCol; j++)
			System.out.println(array[i][j] + " ");
		
		for(int i=startRow, j=endCol; i<=endRow; i++)
			System.out.println(array[i][j] + " ");
		
		for(int i=endRow, j=endCol - 1; j>startCol; j--)
			System.out.println(array[i][j] + " ");
		
		for(int i=endRow, j=startCol; i>startRow; i--)
			System.out.println(array[i][j] + " ");
		
		printMatrixRecursive(array, startRow+1, startCol+1, endRow-1, endCol-1);
	}
}
