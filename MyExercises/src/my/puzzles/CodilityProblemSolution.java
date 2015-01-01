package my.puzzles;

public class CodilityProblemSolution {
	
	/*
	 *	Check if n is a perfect square number 
	 * @param n
	 * @return
	 */
	public boolean isWholeSquare(int n){
		  long tst = (long)(Math.sqrt(n) + 0.5);
		  return tst*tst == n;
	}
	
	/*
	 * Get how many perfect squre numbers between A and B (includes A and B)
	 * @param A
	 * @param B
	 * @return
	 */
	public int getWholeSquareNumber(int A, int B) {
        // write your code in Java SE 8
        int start=0, result = 0;
        if(B<0)
            return 0;
            
        if(A<0){
            start=0;
        }else{
            start=A;
        }
        
        for(int i=start; i<=B; i++){
            if(isWholeSquare(i))
                result++;
        }
        return result;
    }
	
	/*
	 * Values of elements in A >=0 and <=M
	 * Return value of a element which has maximum occurence in A
	 * @param M
	 * @param A
	 * @return
	 */
	public int getMaxOccurence(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 0;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (count[A[i]] >= 0) {
                int tmp = count[A[i]]+1;
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
                count[A[i]] = tmp;
            } else {
                count[A[i]] = 1;
            }
        }
        return A[index];
    }
	
	/*
	 * Break A into three sub arrays. Breaking Points p and q should follow below rule:
	 * 0<p<q-1<A.length-1. The cost of breaking function is A[p] + A[q]
	 * Return the minimum cost value. This solution is not O(n)...Still cannot find O(n) solution.
	 * @param A
	 * @return
	 */
	public int getMinCostOfBreakedChain(int[] A) {
        // write your code in Java SE 8
		int index = 1, minCost = 0;
		for (int i=2; i<=A.length-3; i++){
			index=1;
			while(index+i<A.length-1){
				if(minCost == 0)
					minCost = A[index] + A[index+i];
				else{
					if(minCost>A[index] + A[index+i])
						minCost = A[index] + A[index+i];
				}
				index ++;
			}
		}
		return minCost;
    }
}
