package my.puzzles;

public class N_Queens {
	//Queens Number
	private int queensNum = 0;
	//queens[i]=j => Place a queen in column i and row j
	private int[] queens = null;
	//rowExists[j] = true => There is a queen in row j
	private boolean[] rowExists = null;
	//l2r[l] = true => There is a queen in upper left to right line
	private boolean[] l2r = null; 
	//r2l[r] = true => There is a queen in upper right to left line
	private boolean[] r2l = null;
	
	public N_Queens(int queensNum){
		this.queensNum = queensNum;
		queens = new int[queensNum];
		rowExists = new boolean[queensNum];
		l2r = new boolean[2*queensNum-1]; 
		r2l = new boolean[2*queensNum-1];
		
		for(int i = 0; i < queensNum; i++){
			rowExists[i] = false;
		}
		for(int i = 0; i < 2*queensNum-1; i++){
			l2r[i] = false;
			r2l[i] = false;
		}
	}
	
	public boolean isExists(int row, int col){
		return(rowExists[row] || r2l[row+col] || l2r[queensNum-1+col-row]);
	}
	
	public void resolveNQueens(int column){
		for(int row=0; row<queensNum; row++){
			if(!isExists(row, column)){//It is OK to place a Queen in this row and column
				queens[column] = row;
				rowExists[row] = true;
				r2l[row+column] = true;
				l2r[queensNum-1+column-row]=true;
				
				if(column==queensNum-1){//All queens have been placed into positions
					String[] matrix = new String[queensNum];
					for(int c=0; c<queensNum; c++){
						matrix[queens[c]] = "";
						for(int i=0; i<c; i++){
							matrix[queens[c]] = matrix[queens[c]] + "0 ";
						}
						matrix[queens[c]] = matrix[queens[c]] + "1 ";
						for(int i=c+1; i<queensNum; i++){
							matrix[queens[c]] = matrix[queens[c]] + "0 ";
						}
					}
					for(int i=0; i<queensNum; i++){
						System.out.println(matrix[i]);
					}
					System.out.println("");
				}else{//Place next column queen
					resolveNQueens(column + 1);
				}
				
				//If cannot place next column queen above, here will roll back current placement.
				rowExists[row] = false;
				r2l[row+column] = false;
				l2r[queensNum-1+column-row]=false;
			}
		}
	}
}
