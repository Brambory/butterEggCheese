package butterEggCheese;

import java.util.Scanner;

public class Player {

	private boolean isHuman;
	private int playerNumber;
	private Scanner input;

	
	public Player(boolean human, int playerNumber) {
		
		this.isHuman = human;
		this.playerNumber = playerNumber;
		if(isHuman) {
			input = new Scanner(System.in);
		}
	}
	
	public void displayWinner() {
		System.out.println("Player " + playerNumber+" has won!");
	}
	
	
	
	public int getInput() {
		System.out.println("Player "+ playerNumber +", please provide your next input (1-9):");
//		if(input.hasNext("[A-Za-z]*")){
//			return 0;
//		}
		if(input.hasNextInt()) {
			return input.nextInt();	
		}
		return 0;
	}
	
	public void setPlayerNumber(int num) {
		this.playerNumber = num;
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}
}
