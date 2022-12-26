package butterEggCheese;

public class VictoryConditionTracker {

	private int winnerNumber;	//0 = no winner yet, anything else indicates a player has won
	private boolean isDraw;
	private int numMovesLeft;
	
	public VictoryConditionTracker(StateTracker state) {
		this.winnerNumber = 0;
		this.isDraw = false;
		this.numMovesLeft = 9;
	}
	
	/*
	 * Function returns true when a victory state has been achieved, e.g. when either
	 * there are 3 similar symbols are found in the grid in either horizontal, vertical or diagonal
	 * pattern. 
	 */
	public boolean checkForVictory(StateTracker state) {
		int[][] grid= state.getState();
		int factor = state.getGridSize();
		if (checkHorizontalsTriple(grid, factor)) {
			return true;
		}
		if(checkVerticalsTriple(grid, factor)) {
			return true;
		}
		if(checkDiagonalsTriple(grid, factor)) {
			return true;
		}
		return false;
	}
	
	//returns true when 3-at-a-row horizontals
	private boolean checkHorizontalsTriple(int [][] grid, int factor) {

		for(int i=0;i<=factor;i++) {
			if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
				if(!(grid[i][0] == 0)){
					setWinnerNumber(grid[i][0]);
					return true;
				}
			}
		}
		return false;
	}
	
	//returns true when 3-at-a-row verticles
	private boolean checkVerticalsTriple(int [][] grid, int factor) {
			
		for(int i=0;i<=factor;i++) {
			if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
				if(!(grid[0][i]==0)) {
					setWinnerNumber(grid[0][i]);
					return true;
				}
			}
		}
		return false;
	}
	
	//returns true when 3-at-a-row diagonals
	private boolean checkDiagonalsTriple(int [][] grid, int factor) {
		
		if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
			if(!(grid[0][0]==0)) {
				setWinnerNumber(grid[1][1]);
				return true;
			}	
		}
		if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
			if(!(grid[0][2]==0)) {
				setWinnerNumber(grid[1][1]);
				return true;
			}
		}
		return false;
	}
	
	
	public void displayDraw() {
		System.out.println("No Winner! Game resulted in a draw!");
	}
	
	public void displayNumMovesLeft() {
		System.out.println("Only "+numMovesLeft+" moves left!");
	}
	
	public void setIsDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}
	
	public boolean getIsDraw() {
		return isDraw;
	}
	
	/*
	 * checkIfDraw() currently does displayDraw() which should be moved eventually;
	 * Function uses # of legal moves left (numMovesLeft) as indicator for a draw
	 */
	public boolean checkIfDraw() {
		if(numMovesLeft <=0) {
			setIsDraw(true);
			displayDraw();
			return true;
		}
		return false;
	}
	
	public void setOneTurnLess() {
		this.numMovesLeft = numMovesLeft -1;
	}
	
	public void setOneTurnExtra() {
		this.numMovesLeft = numMovesLeft +1;
	}
	
	public int getNumberOfMovesLeft() {
		return numMovesLeft;
	}
		
	public int getWinnerNumber() {
		return this.winnerNumber;
	}
	
	public void setWinnerNumber(int num) {
		winnerNumber = num;
	}
}
