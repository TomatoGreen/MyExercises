package my.puzzles.test;

import my.puzzles.CodilityProblemSolution;

public class CodilityTest {

	public static void main(String[] args) {
		CodilityProblemSolution solution = new CodilityProblemSolution();
		System.out.println(solution.getWholeSquareNumber(0, 17));
		int[] a = {0,1,2,5,3,4,2,2,1};
		int[] c = {1,2,3,4,5,6,7};
		System.out.println(solution.getMaxOccurence(8, a));
		
		System.out.println(solution.getMinCostOfBreakedChainLinear(c));
	}

}
