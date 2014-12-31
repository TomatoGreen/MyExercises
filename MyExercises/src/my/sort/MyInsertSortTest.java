package my.sort;


public class MyInsertSortTest {

	public static void main(String[] args) {
		int[] array={3,2,7,4,8,34,1,5};
		InsertSort insertSorter = new InsertSort();
		array = insertSorter.insertSort(array);
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}

	}

}
