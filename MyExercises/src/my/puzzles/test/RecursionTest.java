package my.puzzles.test;

import my.puzzles.Counter;
import my.puzzles.N_Queens;

public class RecursionTest {

	public static void main(String[] args) {
		for(int i=0; i<6; i++){
			System.out.print(fabonacci(i) + " ");
		}
		
		System.out.print("\n*******************");
		
		Counter c = new Counter();
		hanoi(4, 'a', 'b', 'c', c);
		System.out.println("Need to Move " + c.getI() + " Times.");
		
		System.out.print("*******************");
		

		System.out.println("Test Case 1");
		char set1[] = {'0', '1'};
		int k1=4;
		printAllKLengthString(set1, "", set1.length, k1);
		
		System.out.println("Test Case 2");
		char set2[] = {'a', 'b', 'c', 'd', 'e'};
		int k2=4;
		printAllKLengthString(set2, "", set2.length, k2);
		
		System.out.println("Test Case 3");
		char set3[] = {'a', 'b', 'c', 'd', 'e'};
		int k3=1;
		printAllKLengthString(set3, "", set3.length, k3);
		
		N_Queens n_Queens_Problem = new N_Queens(4);
		n_Queens_Problem.resolveNQueens(0);
	}

	public static int fabonacci(int n){
		if(n==0){
			return 0;
		}else if(n == 1){
			return 1;
		}else if(n>1){
			return (fabonacci(n-1) + fabonacci(n-2));
		}else{
			return -1;
		}
	}
	
	public static void hanoi(int n, char a, char b, char c, Counter times){
        if(n == 1){
            System.out.println("Disk " + n + " From " + a + " To " + c);
            times.setI(times.getI()+1);
        } else{
        	hanoi(n-1,a,c,b, times);//Move n-1 plates from a to b
            System.out.println("Disk " + n + " From " + a + " To " + c);//Move n(largest) from a to c
            times.setI(times.getI()+1);
            hanoi(n-1,b,a,c, times);//Move all plates from b to c
        }
    }

	public static void printAllKLengthString(char[] characterSet, String prefix, int n, int k){
		if(k==0){
			System.out.println(prefix);
			return;
		}
		
		for(int i=0; i<n; i++){
			String newPrefix = prefix + characterSet[i];
			printAllKLengthString(characterSet, newPrefix, n, k-1);
		}
	}
}
