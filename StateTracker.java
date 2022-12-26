package butterEggCheese;


public class StateTracker {
	
	private int gridSize = 2;
	private int[][] state = null;
	private boolean revertOneTurn = false;
	
	public StateTracker(boolean setInitial) {
		if(setInitial) {
			setInitial();
		}		
		if (state == null) {
			this.state = new int [gridSize][gridSize];
		}
		this.revertOneTurn = false;
	}
	
	public void setInitial() {
		int [][]temp = {{0,0,0},{0,0,0},{0,0,0}};
		this.state = temp;
	}

	public void setTemp(){
		int [][]temp = {{1,2,3},{4,5,6},{7,8,9}};
		this.state = temp;
	}

	/*
	 * Sets a given player input num (1-9), corresponding to a 9-grid game, with the playerNumber
	 * to that square. Uses checkValidMove() to determine whether move is valid.
	 */
	public void setNumberNineOptions(int num, int playerNumber) {
		if(num <=3) {
			int[][] temp = getState();
			if(checkValidMove(temp, num)){
				temp[0][num-1] = playerNumber;
				setState(temp);
			}
			else {
				setRevertOneTurn(true);
				displayWrongMoveMessage();
			}
		}
		else if(num <=6) {
			int[][] temp = getState();
			if(checkValidMove(temp, num)) {
				temp[1][num-4] = playerNumber;
				setState(temp);
			}
			else {
				setRevertOneTurn(true);
				displayWrongMoveMessage();
			}

		}
		else if(num<=9) {
			int[][] temp = getState();
			if(checkValidMove(temp, num)) {
				temp[2][num-7] = playerNumber;
				setState(temp);
			}
			else {
				setRevertOneTurn(true);
				displayWrongMoveMessage();
			}
		}
		else if(num >9) {
			setRevertOneTurn(true);
			displayWrongMoveMessage();
		}
	}
	
	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	
	/*
	 * Checks whether an input is a valid move, e.g. whether the square has not already been 
	 * claimed by either player. Only works for a 9-square grid.
	 */
	public boolean checkValidMove(int[][] state, int input) {
		if(input <=0) {
			return false;
		}
		else if(input <=3) {
			if(state[0][input-1] != 0) {
				return false;
			}
		}
		else if(input<=6) {
			int sub = input-3;
			if(state[1][sub-1] != 0) {
				return false;
			}	
		}
		else if(input<=9) {
			int sub = input-6;
			if(state[2][sub-1] != 0) {
				return false;
			}
		}
		else if(input>9) {
			return false;
		}
		return true;
	}
	
	public void displayWrongMoveMessage() {
		System.out.println("Not a valid move, please try again!");
	}
	
	public int[][] getState() {
		return state;
	}

	public void setState(int[][] state) {
		this.state = state;
	}
	
	public boolean getRevertOneTurn() {
		return revertOneTurn;
	}
	
	public void setRevertOneTurn(boolean value) {
		revertOneTurn = value;
	}
}
