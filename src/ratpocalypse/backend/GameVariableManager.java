package ratpocalypse.backend;

public class GameVariableManager {

	private Handler handler;
	public boolean[] unlocked;
	public int selectedUnit;
	public static int yellowRoses;
	public static int lastYellowRoses;
	public static int difficulty;
	
	public GameVariableManager(Handler handler) {
		this.handler=handler;
		this.unlocked = new boolean[9];
		this.unlocked[0] = true;
		this.selectedUnit = 0;
		this.yellowRoses = 200;
		this.difficulty=1;
	}

}
