package butterEggCheese;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player player1 = new Player(true,1) ;
		Player player2 = new Player(true,2);
		StateTracker state = new StateTracker(true);
		VictoryConditionTracker vic = new VictoryConditionTracker(state);
		GUI_simple gui = new GUI_simple(state);
		StateChanger changer = new StateChanger(player1, player2, state, vic, gui);
		changer.playGame();

	}

}
