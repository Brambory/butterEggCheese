package butterEggCheese;

public class GUI_simple {

	private StateTracker state = null;
	
	public GUI_simple(StateTracker tracker) {
		if(state== null) {
			this.state = tracker;
		}
	}
	
	public void showUserInstructions() {
		System.out.println("Welcome to butterEggCheese!");
		System.out.println("Use the numbers 1 till 9 when prompted to fill in a square, corresponding to a 'cellphone grid'.");
		System.out.println("A 0 displays an empty square, the number 1 or 2 denotes a mark of either player one or two.\n");
	}
	
//	public void showEndInstructions() {
//		System.out.println("Type y for another round?");
//	}
	
	
	
	public void drawSimple() {
		int [][] cur_state = state.getState();
		int gridsize = state.getGridSize();
		for(int i=0;i<=gridsize;i++) {
			for(int j=0;j<=gridsize;j++) {
				System.out.print("|" + cur_state[i][j] + "|");
			}
			System.out.println("\n");
		}
	}
	
	public void drawSimpleFromParam(StateTracker state) {
		int [][] cur_state = state.getState();
		int gridsize = state.getGridSize();
		for(int i=0;i<=gridsize;i++) {
			for(int j=0;j<=gridsize;j++) {
				System.out.print("|" + cur_state[i][j] + "|");
			}
			System.out.println("\n");
		}
	}
}
