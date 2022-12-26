package butterEggCheese;


public class StateChanger {

	
	private Player p1;
	private Player p2;
	private StateTracker state;
	private VictoryConditionTracker vic;
	private GUI_simple gui;
	
	private boolean firstPlayersTurn;
	
	public StateChanger(Player player1, Player player2, StateTracker state, VictoryConditionTracker vic, GUI_simple gui){
		
		this.p1 = player1;
		this.p2 = player2;
		this.state = state;
		this.vic = vic;
		this.gui = gui;
		this.firstPlayersTurn = true;
	}	

	/*
	 * Main game loop; uses state.setInitial() as setup, continues until either no more legal moves
	 * are left (draw) or until a winner is found.
	 */
	public void playGame() {
		int input = 0;
			
			//Setup
			state.setInitial();
			gui.showUserInstructions();
			gui.drawSimpleFromParam(state);
		
			while(vic.getNumberOfMovesLeft()>0) {
				//player takes a turn
				Player current_player = getCurrentPlayer();
				input = current_player.getInput();
				state.setNumberNineOptions(input, current_player.getPlayerNumber());
			
				//in the event of a false move, grant another turn to previous player
				if(state.getRevertOneTurn()) {
					state.setRevertOneTurn(false);
					vic.setOneTurnExtra();
					switchPlayerTurn();
				}
				vic.setOneTurnLess();
			
				//check if draw happened
				if(vic.checkIfDraw()) {
					gui.drawSimpleFromParam(state);
					break;
				}
			
				//check if player has won 
				if(vic.checkForVictory(state)) {
					gui.drawSimpleFromParam(state);
					current_player.displayWinner();
					break;
				}
				else {	//if player has not won, switch players
					gui.drawSimpleFromParam(state);
					vic.displayNumMovesLeft();
					switchPlayerTurn();
				}
			}
	}
	
	

	public void switchPlayerTurn() {
		if(firstPlayersTurn) {
			firstPlayersTurn = false;
		}
		else {
			firstPlayersTurn = true;
		}
	}
	
	public Player getCurrentPlayer() {
		if(firstPlayersTurn) {
			return p1;
		}
		else {
			return p2;
		}
	}
	
	//returns true when it is player 1's turn.
	public boolean getFirstPlayerTurn() {
		return firstPlayersTurn;
	}
	
	public Player getPlayerOne() {
		return p1;
	}
	
	public Player getPlayerTwo() {
		return p2;
	}
	

}
